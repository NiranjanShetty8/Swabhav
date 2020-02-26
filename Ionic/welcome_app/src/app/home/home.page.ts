import { Component } from '@angular/core';
import { stringify } from 'querystring';
import { Contacts, Contact, ContactField, ContactName } from '@ionic-native/contacts'
import { Platform } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  data1: string
  data2: string
  buttonStatus: boolean = true
  result: number


  constructor(private plt: Platform, private contacts: Contacts) {
    this.result = 0;
    this.plt.ready().then((readySource: any) => {
      console.log('Platform ready from', readySource)
      // this.displayAllContacts();
    }, (err) => {
      console.log(err)
    })
  }

  nameChanged() {
    if (this.data1 && this.data2) {
      this.buttonStatus = false
    } else {
      this.result = 0;
      this.buttonStatus = true;
    }
  }

  displayAllContacts() {
    // alert("Hello")
    this.contacts.pickContact()
      .then((response: Contact) => {
        console.log(response)
      }, (err) => {
        console.log(err)
      });

  }

  restartApp() {
    this.buttonStatus = true;
    this.data1 = ""
    this.data2 = ""
    this.result = 0
  }

  showResult() {
    let sum1 = 0
    let sum2 = 0
    for (let i = 0; i < this.data1.length; i++) {
      sum1 += this.data1.charCodeAt(i);
    }
    for (let i = 0; i < this.data2.length; i++) {
      sum2 += this.data2.charCodeAt(i);
    }
    this.result = (sum1 + sum2) % 101;
  }



}
