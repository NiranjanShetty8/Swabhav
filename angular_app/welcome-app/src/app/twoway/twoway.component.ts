import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'swabhav-twoway',
  templateUrl: './twoway.component.html',
  styleUrls: ['./twoway.component.css']
})
export class TwowayComponent implements OnInit {
  firstName: string
  lastName: string

  constructor() {
    this.firstName = "Niranjan"
    this.lastName = "Shetty"

  }

  nameChange(event) {
    console.log(event)
    this.firstName = event
  }

  ngOnInit() {
  }



}
