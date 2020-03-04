package components

import "fmt"

const (
	NoMark   = "-"
	XMark    = "X"
	OMark    = "O"
	ErrorMsg = "Cell has a mark already.\nTry a different Index."
)

type Cell struct {
	mark string
}

func NewCell() *Cell {
	// &Cell.mark = ""
	return &Cell{
		mark: NoMark,
	}
}

func (cell *Cell) SetMark(mark string) error {
	if cell.mark == NoMark {
		cell.mark = mark
		return nil
	}
	return fmt.Errorf(ErrorMsg)
}

func (cell *Cell) GetMark() string {
	return cell.mark
}
