package main

import "fmt"

func main() {
	slice := []int{10, 20, 30, 40, 50}
	fmt.Println(&slice[0])
	// fmt.Println(*0xc00000a300)
	modify(slice)
	fmt.Println(slice)
	// modify2(&slice)

}

func modify(slice []int) {
	for i := range slice {
		slice[i] = 0
	}
}

func modify2(slice *[]int) {
	// for i := range slice {
	// 	fmt.Println(slice)
	// }
}
