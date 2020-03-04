package service

import (
	"math"
	"tic_tac_toe_app/components"
	"tic_tac_toe_app/player"
)

type BoardService struct {
	Board *components.Board
}

func NewBoardService(board *components.Board) *BoardService {
	return &BoardService{
		Board: board,
	}
}

func (board *BoardService) PutMarkInPosition(player *player.Player, position uint8) error {
	// boardSizeErrorMsg := "Position does not exist. Enter a number higher than 0 & lower than " + fmt.Sprintf("%v", board.Board.Size)
	// if position > board.Board.Size {
	// 	return fmt.Errorf(boardSizeErrorMsg)
	// }
	markError := board.Board.Cells[position].SetMark(player.Mark)
	if markError != nil {
		return markError
	}
	return nil
}

func (board *BoardService) GetAllMarks() []*components.Cell {
	allCells := board.Board.Cells
	return allCells
}

func (board *BoardService) CheckIfBoardIsFull() bool {
	allCells := board.Board.Cells
	for _, cell := range allCells {
		if cellMark := cell.GetMark(); cellMark == components.NoMark {
			return false
		}
	}
	return true
}

func (board *BoardService) PrintBoard() string {
	allCells := board.GetAllMarks()
	rowSize := int(math.Sqrt(float64(len(allCells))))
	var printedBoard string = " "
	counter := 1
	for _, cell := range allCells {
		printedBoard += cell.GetMark() + " "

		if counter == rowSize {
			printedBoard += "\n" + " "
			counter = 0
		}
		counter++
	}
	return printedBoard
}
