import { Component, OnInit, Input } from '@angular/core';
import { MasterComponent } from '../master/master.component'

@Component({
    selector: 'sw-toggle',
    templateUrl: './toggle.component.html',
    styleUrls: ['./toggle.component.css']
})

export class ToggleComponent implements OnInit {
    @Input() title: string
    state: number = 0
    @Input() onColor: string = "red"
    @Input() set: boolean = true
    @Input() offColor: string


    constructor() {
        console.log("in constructor")
        console.log(this.title)
    }

    changeState() {
        if (this.state == 0) {
            this.state = 1
        } else {
            this.state = 0
        }
        console.log(this.state)
    }


    ngOnInit(): void {
        console.log("In on INIT");
        console.log(this.title)
    }

}