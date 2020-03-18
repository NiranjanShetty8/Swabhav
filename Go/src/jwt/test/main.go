package main

//This code checks the token  before calling the function
// Access is given only if the token is valid.

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
	"os"
	"time"

	jwt "github.com/dgrijalva/jwt-go"
	"github.com/dgrijalva/jwt-go/request"
	"github.com/gorilla/mux"
)

var secretKey = []byte(os.Getenv("SESSION_SECRET"))
var users = map[string]string{"naren": "passme", "admin": "password"}

// Response is a representation of JSON response for JWT
type Response struct {
	Token  string `json:"token"`
	Status string `json:"status"`
}

// HealthcheckHandler returns the date and time
func HealthcheckHandler(w http.ResponseWriter, r *http.Request) {
	tokenString, err := request.HeaderExtractor{"access_token"}.ExtractToken(r)
	token, err := jwt.Parse(tokenString, func(token *jwt.Token) (interface{}, error) {
		// Don't forget to validate the alg is what you expect:
		if _, ok := token.Method.(*jwt.SigningMethodHMAC); !ok {
			return nil, fmt.Errorf("Unexpected signing method: %v", token.Header["alg"])
		}

		// hmacSampleSecret is a []byte containing your secret, e.g. []byte("my_secret_key")
		return secretKey, nil
	})
	if err != nil {
		w.WriteHeader(http.StatusForbidden)
		w.Write([]byte("Access Denied; Please check the access token"))
		return
	}
	if claims, ok := token.Claims.(jwt.MapClaims); ok && token.Valid {
		// If token is valid
		response := make(map[string]string)
		// response["user"] = claims["username"]
		response["time"] = time.Now().String()
		response["user"] = claims["username"].(string)
		responseJSON, _ := json.Marshal(response)
		w.Write(responseJSON)
	} else {
		w.WriteHeader(http.StatusForbidden)
		w.Write([]byte(err.Error()))
	}
}

// LoginHandler validates the user credentials
func getTokenHandler(w http.ResponseWriter, r *http.Request) {
	err := r.ParseForm()
	if err != nil {
		http.Error(w, "Please pass the data as URL form encoded", http.StatusBadRequest)
		return
	}
	log.Println(r.PostForm)
	username := r.PostForm.Get("username")
	password := r.PostForm.Get("password")
	log.Println("username ", username)
	log.Println("password", password)
	if originalPassword, ok := users[username]; ok {
		if password == originalPassword {

			// Create a claims map
			claims := jwt.MapClaims{
				"username": username,
				"IssuedAt": time.Now().Unix(),
			}
			token := jwt.NewWithClaims(jwt.SigningMethodHS256, claims)
			tokenString, err := token.SignedString(secretKey)
			if err != nil {
				w.WriteHeader(http.StatusBadGateway)
				w.Write([]byte(err.Error()))
			}
			response := Response{Token: tokenString, Status: "success"}
			responseJSON, _ := json.Marshal(response)
			w.WriteHeader(http.StatusOK)
			w.Header().Set("Content-Type", "application/json")
			w.Write(responseJSON)

		} else {
			http.Error(w, "Invalid Credentials", http.StatusUnauthorized)
			return
		}
	} else {
		http.Error(w, "User is not found", http.StatusNotFound)
		return
	}
}

func main() {
	r := mux.NewRouter()
	subRouter := r.PathPrefix("/user").Subrouter()
	subRouter.Use(MyCustomAuthMiddleware)
	subRouter.HandleFunc("/hello", test)
	subRouter.HandleFunc("/goodbye", test)
	r.HandleFunc("/getToken", getTokenHandler)
	r.HandleFunc("/healthcheck", HealthcheckHandler)

	http.Handle("/", r)
	srv := &http.Server{
		Handler: r,
		Addr:    ":8000",
		// Good practice: enforce timeouts for servers you create!
		WriteTimeout: 15 * time.Second,
		ReadTimeout:  15 * time.Second,
	}
	log.Fatal(srv.ListenAndServe())
}

func Validate( /*w http.ResponseWriter,*/ r *http.Request) bool {
	tokenString, err := request.HeaderExtractor{"access_token"}.ExtractToken(r)
	token, err := jwt.Parse(tokenString, func(token *jwt.Token) (interface{}, error) {
		// Don't forget to validate the alg is what you expect:
		if _, ok := token.Method.(*jwt.SigningMethodHMAC); !ok {
			return nil, fmt.Errorf("Unexpected signing method: %v", token.Header["alg"])
		}

		// hmacSampleSecret is a []byte containing your secret, e.g. []byte("my_secret_key")
		return secretKey, nil
	})
	if err != nil {
		// w.WriteHeader(http.StatusForbidden)
		// w.Write([]byte("Access Denied; Please check the access token"))
		return false
	}
	if claims, ok := token.Claims.(jwt.MapClaims); ok && token.Valid {
		// If token is valid
		response := make(map[string]string)
		// response["user"] = claims["username"]
		response["time"] = time.Now().String()
		response["user"] = claims["username"].(string)
		// responseJSON, _ := json.Marshal(response)
		// w.Write(responseJSON)
		return true
	} else {
		// w.WriteHeader(http.StatusForbidden)
		// w.Write([]byte(err.Error()))
		return false
	}
}
func test(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("test"))

}
func MyCustomAuthMiddleware(h http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		if Validate(r) {
			log.Println("Before... accessing")
			h.ServeHTTP(w, r)
			log.Println("After... accessing")
		} else {
			w.Write([]byte("Bad token"))
		}
	})
}
