package account

type Account struct {
	accNo   int
	accName string
	balance float64
}

func NewAccount(accNo int, accName string, balance float64) *Account {
	if balance < 0 {
		panic("Balance is less than zero")
	}
	return &Account{
		accNo, accName, balance,
	}
}

func (acc *Account) Deposit(amount float64) {
	acc.balance += amount
}

func (acc *Account) Withdraw(amount float64) {
	if acc.balance-amount < 500 {
		panic("Min balance of 500 should be maintained.")
	}
	acc.balance -= amount
}

func (acc *Account) Balance() float64 {
	return acc.balance
}
func (acc *Account) AccName() string {
	return acc.accName
}
func (acc *Account) AccNo() int {
	return acc.accNo
}
