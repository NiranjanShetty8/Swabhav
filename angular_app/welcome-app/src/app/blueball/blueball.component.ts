import { Component, OnInit } from '@angular/core';
interface IBall {
  color: string
  id: number


}

@Component({
  selector: 'swabhav-blueball',
  templateUrl: './blueball.component.html',
  styleUrls: ['./blueball.component.css']
})


export class BlueballComponent implements OnInit {
  gameRunning = false



  constructor() { }

  ngOnInit() {
  }

}
