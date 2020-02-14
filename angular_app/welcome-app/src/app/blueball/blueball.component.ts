import { Component, OnInit } from '@angular/core';

interface IBall {
  defaultColor: string
  id: number
  disabled: boolean
}

@Component({
  selector: 'swabhav-blueball',
  templateUrl: './blueball.component.html',
  styleUrls: ['./blueball.component.css']
})


export class BlueballComponent implements OnInit {
  balls: IBall[]
  gameRunning: boolean = false
  gameFinished: boolean = false
  maxballs: number
  attempts: number
  winningNumber: number

  generateAllBalls() {
    for (let i = 0; i < 50; i++) {
      this.balls.push({
        id: i + 1,
        defaultColor: "grey",
        disabled: false
      });

    }
  }

  onGuess(id: number) {
    this.balls[id - 1].disabled = true;
    this.attempts--
    if (id == this.winningNumber) {
      this.balls[id - 1].defaultColor = "blue";
      for (let i = 0; i < 50; i++) {
        this.balls[i].disabled = true;
      }
      this.gameFinished = true;
      setTimeout(function () {
        alert("Congratulations!! You won ")
      }, 10);

    } else if (id > this.winningNumber) {
      this.balls[id - 1].defaultColor = "red";
    } else {
      this.balls[id - 1].defaultColor = "green";
    }
    if (this.attempts == 0) {
      alert("Sorry all your attempts are over. Try again")
      this.playAgain()
    }
  }

  playAgain() {
    this.gameFinished = true
    // if (confirm('Wanna Play again?')) {
    //   this.startGame()
    // } else {
    //   this.gameRunning = false;
    // }
  }

  generateWinNumber() {
    this.winningNumber = (Math.floor(Math.random() * 50) + 1)
    console.log(this.winningNumber)
  }

  startGame() {
    this.gameFinished = false
    this.generateWinNumber();
    this.attempts = 5;
    this.maxballs = 50;
    this.gameRunning = true
    this.balls = []
    this.generateAllBalls();
  }

  endGame() {
    this.gameRunning = false
    this.gameFinished = false
  }

  constructor() { }

  ngOnInit() {
    this.gameRunning = false
  }
}