package main

import (
	"account_app/account"
	"fmt"
)

func main() {
	acc := account.NewAccount(101, "Niranjan", 5000)
	fmt.Print(acc)
	// fmt.Println(account.NewAccount(102, "bcdd", 300))
	printInfo(acc)
	acc.Withdraw(450)
	printInfo(acc)
	acc.Deposit(10000)
	printInfo(acc)

}

func printInfo(acc *account.Account) {
	fmt.Printf("Account Name is %s\nAccount Number is %d\nAccount Balance is %.2f\n", acc.AccName(), acc.AccNo(), acc.Balance())

}
