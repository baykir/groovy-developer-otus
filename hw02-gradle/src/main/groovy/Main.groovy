class Main {
    static void main(String[] args) {
        ATM atm = new ATM()
        def cash = [10:2, 500:1, 2000:10, 5000:3]
        atm.deposit(cash)

        println atm.balance()


        def userCash = atm.withdraw(7510)
        println userCash

        println atm.balance()
    }
}
