package main

import (
	"fmt"
	"math/rand"
	"strconv"
	"time"
)

func main() {
	noOfAttempts := 5
	fmt.Println("Welcome to the number guessing game.\nYou get 5 attempts")
	actualNo := generateRandomNumber()
	guess := getGuess()

	for noOfAttempts > 0 {

		result := checkResult(guess, actualNo)
		if result {
			fmt.Println("Congratulations, You guesssed the correct number")
			return
		}
		if noOfAttempts == 1 {
			fmt.Println("All attempts are over. The number was ", actualNo)
			return
		}
		noOfAttempts--
		fmt.Println("Oops, Wrong guess. Try Again \nRemaining Attempts :", noOfAttempts, actualNo)
		guess = getGuess()

	}

}

func getGuess() int {
	fmt.Println("Guess the number:")
	var guess string
	fmt.Scanln(&guess)
	guessNum, err := strconv.Atoi(guess)
	if err != nil {
		fmt.Println("That is NOT A NUMBER. Please Enter a number")
		getGuess()
	}
	return guessNum
}
func generateRandomNumber() int {
	rand.Seed(time.Now().UnixNano())
	max := 9
	randNo := rand.Intn(max + 1)
	return randNo
}

func checkResult(guess int, randNo int) bool {
	if guess > randNo {
		fmt.Println("Guess is higher than actual number")
		return false
	} else if guess < randNo {
		fmt.Println("Guess is lower than actual number")
		return false
	}
	return true
}
