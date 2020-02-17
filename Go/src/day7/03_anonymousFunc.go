package main

import "fmt"

func main() {
	case1()
	case2()
	case3()
	case4()
	case5()
}

// func(){
// 	"Hello World"
// }()

func case1() {
	func() {
		fmt.Println("Case 1 called")
	}()
}

func case2() {
	f1 := func(name string) {
		fmt.Println("Hello " + name)
	}
	f1("Niranjan")
}

func case3() {
	f1 := giveFunction()
	fmt.Println(f1(10, 30))
}

func giveFunction() func(float64, float64) float64 {
	return func(n1, n2 float64) float64 {
		return n1 + n2
	}
}

func case4() {
	doProcessing(2, func(r string) {
		fmt.Println(r)
	})
}

func doProcessing(no int, callback func(string)) {
	callback(fmt.Sprintf("Process things in function %d", no+no))
}

func case5() {
	var manyFunctions []func() int
	for i := 1; i <= 5; i++ {
		cleanI := i * 10
		manyFunctions = append(manyFunctions, func(i int) func() int {
			return func() int {
				return cleanI
			}
		}(i))
	}
	fmt.Println(manyFunctions[0]())

	for i := 0; i < 5; i++ {
		fmt.Println(manyFunctions[i]())
	}

}
