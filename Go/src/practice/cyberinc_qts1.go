package main

import (
	"fmt"
)

func main() {
	var (
		noOfTrees   int
		noOfDays    int
		aArray      []int
		bArray      []int
		finalArray  []int
		scannedNo   int
		max         int
		resultArray []int
	)
	fmt.Scanf("%d %d", &noOfTrees, &noOfDays)

	fmt.Scanln()
	for i := 0; i < noOfTrees; i++ {
		fmt.Scanf("%d", &scannedNo)
		aArray = append(aArray, scannedNo)
		finalArray = append(finalArray, scannedNo)
		max = finalArray[0]
		// fmt.Println("this", aArray)
	}
	fmt.Scanln()
	for i := 0; i < noOfTrees; i++ {
		fmt.Scanf("%d", &scannedNo)
		bArray = append(bArray, scannedNo)
		// fmt.Println(bArray)
	}

	//Optimized
	for j := 0; j < noOfTrees; j++ {
		finalArray[j] += bArray[j] * noOfDays
		if finalArray[j] > max {
			max = finalArray[j]
		}
	}

	// for i := 0; i < noOfDays; i++ {
	// 	for j := 0; j < noOfTrees; j++ {
	// 		finalArray[j] += bArray[j]
	// 		if finalArray[j] > max {
	// 			max = finalArray[j]
	// 		}
	// 	}
	// }

	for i := 0; i < noOfTrees; i++ {
		if finalArray[i] == max {
			resultArray = append(resultArray, i+1)
			// fmt.Println(resultArray)
		}
	}
	// fmt.Println(max)
	// fmt.Println(finalArray)
	// fmt.Println(aArray)
	// fmt.Println(bArray)
	fmt.Println(resultArray)

}
