package main

import (
	"fmt"
	"strconv"
	"tic_tac_toe_app/components"
	"tic_tac_toe_app/player"
	service "tic_tac_toe_app/services"
)

//have to handle index higher than size

func main() {
	var (
		scannedString string
		size          uint8
		index         uint8
		temp          int
	)
	fmt.Println("Welcome to the TIC TAC TOE GAME\n")
	fmt.Println("Enter the name of the First Player")
	fmt.Scanln(&scannedString)
	player1 := player.NewPlayer(scannedString)
	fmt.Println("Enter the name of the Second player")
	fmt.Scanln(&scannedString)
	player2 := player.NewPlayer(scannedString)
	fmt.Printf("%s,You are going to be %s\n", player1.Name, player1.Mark)
	fmt.Printf("%s,You are going to be %s\n", player2.Name, player2.Mark)
	for {
		fmt.Println("\n[Enter '3' for 3x3 board]\nEnter the size of the board:")
		_, err := fmt.Scan(&scannedString)
		temp, err = strconv.Atoi(scannedString)
		if err != nil {
			fmt.Println("Enter a valid number which is higher than ONE")
			continue
		} else if temp < 2 {
			fmt.Println("Enter a number higher than ONE.")
			continue
		}
		size = uint8(temp)
		break
	}
	allPlayers := [2]*player.Player{player1, player2}
	board := components.CreateBoard(size)
	boardService := service.NewBoardService(board)
	result := &service.Result{}
	resultService := service.NewResultService(boardService, result)
	gameService := service.NewGameService(allPlayers, boardService, resultService)
	fmt.Println("\nGame Starts")

	for {
		var scanned string
		currentPlayer := gameService.GetCurrentPlayer()
		indexLimit := len(boardService.Board.Cells)
		fmt.Printf("\n%s's turn to play:", currentPlayer.Name)
		fmt.Println("\nEnter the index to put your mark:")
		fmt.Scan(&scanned)
		// fmt.Println(a, b)
		temporary, markErr := strconv.Atoi(scanned)
		index = uint8(temporary)
		if markErr != nil {
			fmt.Printf("\nEnter a valid input [number from 0 to %v ]", indexLimit-1)
			continue
		} else if index >= uint8(indexLimit) {
			fmt.Printf("\nIndex Exceeded Board size.\nEnter a number below %v", indexLimit)
			continue
		}
		result, err := gameService.Play(index)
		if err != nil {
			str := fmt.Sprint(err)
			fmt.Println(str)
			continue
		}
		fmt.Println(boardService.PrintBoard())
		if result.Draw {
			fmt.Println("Tha Game is a Draw!!\nWell played Both of you!!")
			break
		} else if result.Win {
			fmt.Printf("Congratulations!! %s won the Game!!", currentPlayer.Name)
			break
		}

	}
}
