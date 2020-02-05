interface ICustomer {
    firstName: string,
    lastName: string,
    balance: number,
    description?: string
}

function printInfo(customer: ICustomer[]) {
    for (var cust in customer) {
        console.log(cust)
    }
    for (var c of customer) {
        console.log(c)
    }
}

printInfo([{ balance: 5000, lastName: "Techlabs", firstName: "Swabhav" }]);