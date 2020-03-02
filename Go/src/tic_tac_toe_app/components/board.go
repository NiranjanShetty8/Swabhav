package components

type Board struct {
	Cells []*Cell
	Size  uint8
}

func CreateBoard(size uint8) *Board {
	size *= size
	var cellArray = make([]*Cell, size)
	var i uint8 = 0
	for ; i < size; i++ {
		cellArray[i] = NewCell()
	}
	return &Board{
		Cells: cellArray,
		Size:  size,
	}
}
