package service

import (
	"tic_tac_toe_app/player"
)

var playerFlag bool = false

type Game struct {
}

type GameService struct {
	Players       [2]*player.Player
	BoardService  *BoardService
	ResultService *ResultService
}

func NewGameService(players [2]*player.Player, boardService *BoardService, resultService *ResultService) *GameService {
	return &GameService{
		Players:       players,
		BoardService:  boardService,
		ResultService: resultService,
	}
}

func (game *GameService) switchCurrentPlayer() *player.Player {
	playerFlag = !playerFlag
	var player *player.Player
	if playerFlag {
		player = game.Players[0]
	} else {
		player = game.Players[1]
	}
	return player
}

func (game *GameService) GetCurrentPlayer() *player.Player {
	if !playerFlag {
		return game.Players[0]
	}
	return game.Players[1]

}

func (game *GameService) Play(index uint8) (*Result, error) {
	player := game.switchCurrentPlayer()
	markError := game.BoardService.PutMarkInPosition(player, index)
	if markError != nil {
		player = game.switchCurrentPlayer()
		return nil, markError
	}
	result := game.ResultService.GetResult(player.Mark, index)
	return result, nil

}
