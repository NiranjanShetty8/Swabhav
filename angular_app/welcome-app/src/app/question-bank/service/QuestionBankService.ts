import { IQuestion } from './IQuestion'
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: "root"
})
export class QuestionBankService {
    allQuestions: IQuestion[]
    // questionNumber : number
    constructor() {
        this.allQuestions = [{
            id: 1, body: "What is 144 * 9?", options: ["1286", "1276", "1296", "1306"],
            correctAnswer: "2"
        }, {
            id: 2, body: "Which is my color?", options: ["Black", "Brown", "Red", "Sky-Blue"],
            correctAnswer: "0"
        }, {
            id: 3, body: "What is 1 + 1", options: ["0", "2", "1", "5"],
            correctAnswer: "1"
        }, {
            id: 4, body: "Which is the correct choice?", options: ["Mixer", "Juicer", "Grinder", "Oven"],
            correctAnswer: "1"
        }, {
            id: 5, body: "Guess the Vegetable.", options: ["Tomato", "Ginger", "Garlic", "BeetRoot"],
            correctAnswer: "2"
        }]
    }
    getQuestions(): IQuestion[] {

        return this.allQuestions
        // var stringAllQuestions = JSON.stringify(allQuestions);
        // localStorage.setItem("allQuestions", stringAllQuestions);
    };

    count(): number {
        return this.allQuestions.length
    }

};

