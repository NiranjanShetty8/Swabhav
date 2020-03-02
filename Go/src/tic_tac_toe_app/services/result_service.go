package service

type ResultService struct {
	BoardService BoardService
}

func NewResultService(boardService *BoardService) *ResultService {
	return &ResultService{
		BoardService: *boardService,
	}
}
func (rService *ResultService) CheckForwardDiagonal() {

}

// public boolean checkForwardDiagonal(Mark mark, int index) {
// 	int firstIndex = 0;
// 	int limit = (int) Math.sqrt(cellList.size());
// 	if (index % limit == index / limit) {
// 		for (int i = firstIndex; i < cellList.size(); i = i + limit + 1) {
// 			if (cellList.get(i).getMark() != mark) {
// 				return false;
// 			}
// 		}
// 		return true;
// 	}
// 	return false;
// }
