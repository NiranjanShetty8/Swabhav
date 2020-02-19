package math

import "testing"

func TestAddNo(t *testing.T) {
	input1, input2 := 10, 20
	expected := 30

	actual := addNo(input1, input2)

	if expected != actual {
		t.Errorf("Expected %v but Actual is %v", expected, actual)
	}
}
