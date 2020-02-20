package math

import (
	"testing"
)

func TestSumArrayNoFlag(t *testing.T) {
	testData := []string{"10", "20", "30", "40"}
	expectedArr := []float64{10, 20, 30, 40}
	var expectedSum float64 = 100
	var expectedError error = nil
	actualArr, actualSum, actualError := sumArray(testData)

	for i := 0; i < len(expectedArr); i++ {
		if expectedArr[i] != actualArr[i] {
			t.Errorf("Error : %f is not equal to %f ", +expectedArr[i], actualArr[i])
		}
	}

	if expectedSum != actualSum || expectedError != actualError {
		t.Errorf("Error: %f is not equal to %f", expectedSum, actualSum)
	}

}
func TestSumArrayOddFlag(t *testing.T) {
	testData := []string{"10", "20", "30", "-o", "40", "55"}
	expectedArr := []float64{55}
	var expectedSum float64 = 55
	var expectedError error = nil
	actualArr, actualSum, actualError := sumArray(testData)

	for i := 0; i < len(expectedArr); i++ {
		if expectedArr[i] != actualArr[i] {
			t.Errorf("Error : %f is not equal to %f ", +expectedArr[i], actualArr[i])
		}
	}

	if expectedSum != actualSum || expectedError != actualError {
		t.Errorf("Error: %f is not equal to %f", expectedSum, actualSum)
	}

}
func TestSumArrayEvenFlag(t *testing.T) {
	testData := []string{"10", "20", "30", "40", "-e", "55"}
	expectedArr := []float64{10, 20, 30, 40}
	var expectedSum float64 = 100
	var expectedError error = nil
	actualArr, actualSum, actualError := sumArray(testData)

	for i := 0; i < len(expectedArr); i++ {
		if expectedArr[i] != actualArr[i] {
			t.Errorf("Error : %f is not equal to %f ", +expectedArr[i], actualArr[i])
		}
	}

	if expectedSum != actualSum || expectedError != actualError {
		t.Errorf("Error: %f is not equal to %f", expectedSum, actualSum)
	}

}
