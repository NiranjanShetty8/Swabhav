package main

import (
	"fmt"
)

func main() {
	if r, err := cubeEvenNumber(3); err != nil {
		fmt.Println(err.Error())
	} else {
		fmt.Println("The cubed number is ", r)
	}

}

func cubeEvenNumber(no int) (int, error) {
	if no%2 != 0 {
		return 0, &notEvenError{no}
	}
	return no * no * no, nil
}

type notEvenError struct {
	no int
}

func (e *notEvenError) Error() string {
	return fmt.Sprintln(e.no, "is not an even number")
}
