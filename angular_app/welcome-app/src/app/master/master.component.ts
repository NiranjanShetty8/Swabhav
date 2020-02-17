import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'sw-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.css']
})
export class MasterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  toggleHandler($event) {
    console.log($event)
  }


  ratingHandler($event) {
    console.log("Master says :", $event)
  }



}
