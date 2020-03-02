package player

import (
	"tic_tac_toe_app/components"
)

var flag = false

type Player struct {
	Name string
	Mark string
}

func NewPlayer(name string) *Player {
	flag = !flag
	if flag {
		return &Player{
			Name: name,
			Mark: components.XMark,
		}
	}
	return &Player{
		Name: name,
		Mark: components.OMark,
	}
}
