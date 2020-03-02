package components

import "fmt"

const (
	NoMark   = ""
	XMark    = "X"
	OMark    = "O"
	ErrorMsg = "Cell has a mark already"
)

type Cell struct {
	mark string
}

func NewCell() *Cell {
	// &Cell.mark = ""
	return &Cell{
		mark: "",
	}
}

func (cell *Cell) SetMark(mark string) error {
	if cell.mark == "" {
		cell.mark = mark
		return nil
	}
	return fmt.Errorf(ErrorMsg)
}

func (cell *Cell) GetMark() string {
	return cell.mark
}
