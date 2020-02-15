import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'sw-toggle',
    templateUrl: './toggle.component.html',
    styleUrls: ['./toggle.component.css']
})

export class ToggleComponent implements OnInit {
    @Input() title: string
    state: number = 0
    set: boolean
    @Input() offColor: string
    @Input() onColor: string
    @Output() toggleEvent: EventEmitter<string>


    constructor() {
        console.log("in constructor")
        console.log(this.title)
        console.log(this.set)
        this.toggleEvent = new EventEmitter<string>();
    }

    clickHandler() {
        if (this.state == 0) {
            this.state = 1
            this.set = true;
        } else {
            this.state = 0
            this.set = false;
        }
        this.toggleEvent.emit("Trying to emit from child " + this.state);
    }

    // changeState() {
    //     if (this.state == 0) {
    //         this.state = 1
    //         this.set = true;
    //     } else {
    //         this.state = 0
    //         this.set = false;
    //     }
    //     console.log(this.state)
    // }


    ngOnInit(): void {
        console.log("In on INIT");
        console.log(this.title)

    }

}