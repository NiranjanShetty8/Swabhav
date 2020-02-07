package main

import (
	"errors"
	"fmt"
)

func main() {
	if r, err := cubeEvenNumbers(3); err != nil {
		fmt.Println(err.Error())
	} else {
		fmt.Println("The cubed number is : ", r)
	}

}

func cubeEvenNumbers(no int) (int, error) {
	if no%2 != 0 {
		// no = strconv(no)
		// return 0, errors.New(no + " is not an even number")
		return 0, errors.New(fmt.Sprintln(no, " is not an even number"))
	}
	return no * no * no, nil
}
