package service

import (
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

func (board *BoardService) PutMarkInPosition(player *player.Player, position int) error {
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
