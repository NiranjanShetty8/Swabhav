{
version :"0.2.0",
"configurations" :[

import (
	"fmt"
	"runtime"
)

func main() {
	fmt.Println("Hello from fmt Println")
	fmt.Println(runtime.GOOS)
	fmt.Println(runtime.GOARCH)
}
]
}
