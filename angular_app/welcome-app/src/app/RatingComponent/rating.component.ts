import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core'

@Component({
    selector: 'sw-rating',
    templateUrl: './rating.component.html',
    styleUrls: ['./rating.component.css']

})

export class RatingComponent implements OnInit {

    @Input() rating: number
    @Output() ratingEvent: EventEmitter<number>

    constructor() {
        this.ratingEvent = new EventEmitter<number>();
        this.ratingEvent.emit(this.rating);
        console.log(this.ratingEvent)

    }


    ngOnInit() {
    }


}