package math

import (
	"fmt"
	"testing"
)

func TestIsEven(t *testing.T) {
	testData := []struct {
		no     int
		result bool
	}{
		{10, true},
		{35, false},
		{50, true},
	}

	for _, data := range testData {
		t.Run("Match", func(t *testing.T) {
			actualResult := isEven(data.no)
			if actualResult != data.result {
				t.Errorf(formatError(data.no, data.result, actualResult))
			}
		})

	}

}

func formatError(num int, expected, actual bool) string {
	return fmt.Sprintf("Number is %d\n Expected result is %v\n Actual result is %v", num, expected, actual)
}
