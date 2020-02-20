package math

import (
	"math"
	"strconv"
)

// func main() {
// 	stArray := []string{"10"}
// 	stArray = append(stArray, "20", "30", "40", "55", "hello", "-o")
// 	fmt.Println(sumArray(stArray))

// }

func parseFlag(stArr []string) int {
	for _, str := range stArr {
		_, err := strconv.ParseFloat(str, 64)
		if err != nil {
			if str == "-e" {
				return 1
			} else if str == "-o" {
				return 2
			}
		}
	}
	return 0
}

func sumArray(stArr []string) ([]float64, float64, error) {
	no := parseFlag(stArr)
	stringArray := []float64{}
	var sum float64 = 0
	for _, str := range stArr {
		data, err := strconv.ParseFloat(str, 64)
		if err != nil {
			continue
		}
		if no == 1 {
			if res := math.Mod(data, 2); res != 0 {
				continue
			}
			stringArray = append(stringArray, data)

		} else if no == 2 {
			if res := math.Mod(data, 2); res == 0 {
				continue
			}
			stringArray = append(stringArray, data)

		} else {
			stringArray = append(stringArray, data)
		}

	}
	for _, num := range stringArray {
		sum += num
	}
	return stringArray, sum, nil
}
