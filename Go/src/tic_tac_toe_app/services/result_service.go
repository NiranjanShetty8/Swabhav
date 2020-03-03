package service

import "math"

type ResultService struct {
	BoardService *BoardService
}

//Try to make limit global

func NewResultService(boardService *BoardService) *ResultService {
	return &ResultService{
		BoardService: boardService,
	}
}

func (rs *ResultService) checkResult {
	
}

public Result giveResult(Board b,Mark mark,int index) {
	Result result = Result.PROCESS;
	boolean resultCheck = checkRow(mark, index)|| 
			checkColumn(mark, index) ||
			checkForwardDiagonal(mark, index) || 
			checkReverseDiagonal(mark, index);
	if(resultCheck) {
		return Result.WIN;
	}
	else if(b.checkIfBoardIsFull()) {
		return Result.DRAW;
	}
	return result;
}

func (rs *ResultService) checkForwardDiagonal(mark string, index uint8) bool {
	var firstIndex uint8 = 0
	root := float64(rs.BoardService.Board.Size)
	limit := uint8(math.Sqrt(root))
	cellArr := rs.BoardService.Board.Cells
	size := len(cellArr)
	if index%limit == index/limit {
		for i := firstIndex; i < uint8(size); i = i + limit + 1 {
			if cellArr[i].GetMark() != mark {
				return false
			}
		}
		return true
	}
	return false
}

func (rs *ResultService) checkReverseDiagonal(mark string, index uint8) bool {
	root := float64(rs.BoardService.Board.Size)
	limit := uint8(math.Sqrt(root))
	firstIndex := limit - 1
	cellArr := rs.BoardService.Board.Cells
	size := len(cellArr)
	if (index%limit)+(index/limit) == firstIndex {
		for i := firstIndex; i < uint8(size-1); i = i + firstIndex {
			if cellArr[i].GetMark() != mark {
				return false
			}
		}
		return true
	}
	return false
}
func (rs *ResultService) checkRow(mark string, index uint8) bool {
	cellArr := rs.BoardService.Board.Cells
	root := float64(rs.BoardService.Board.Size)
	limit := uint8(math.Sqrt(root))
	row := index / limit
	firstIndex := row * limit
	for i := firstIndex; i < firstIndex+limit; i++ {
		if cellArr[i].GetMark() != mark {
			return false
		}
	}
	return true
}

func (rs *ResultService) checkColumn(mark string, index uint8) bool {
	cellArr := rs.BoardService.Board.Cells
	root := float64(rs.BoardService.Board.Size)
	limit := uint8(math.Sqrt(root))
	size := uint8(len(cellArr))
	firstColumn := index % limit
	for i := firstColumn; i < size; i = i + limit {
		if cellArr[i].GetMark() != mark {
			return false
		}
	}
	return true
}
