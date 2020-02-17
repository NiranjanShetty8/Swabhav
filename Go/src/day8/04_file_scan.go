package main

import (
	"fmt"
	"io/ioutil"
	"os"
)

func main() {
	name := "d:/Swabhav/Swabhav/Go/src/day8/parent"
	scanFile(name)

}

func scanFile(path string) {
	fmt.Println(path)

	fi, err := os.Stat(path)
	// fmt.Println("fi is", fi)
	if err != nil {
		fmt.Println(err)
		return
	}
	if fi.Mode().IsDir() {

		// fmt.Println("FI mode is :", fi.Mode())
		// fmt.Println(fi.Name())
		files, err := ioutil.ReadDir(path)
		if err != nil {
			fmt.Println(err)
		}

		for _, file := range files {
			newPath := path + "/" + file.Name()
			scanFile(newPath)
		}
	}

}

// else {
// 	fmt.Println("In else", path)
// }
