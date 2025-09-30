class Runner {
    static void main(String[] args) {
        ATM_new atm_new = new ATM_new([10, 50, 100, 500, 1000, 2000, 5000])

        println atm_new.atm

        atm_new.deposit(5000, 1)
        atm_new.deposit(100, 3)
        atm_new.deposit(10, 100)
        atm_new.deposit(2000, 1)
        atm_new.deposit(500, 4)

        println(atm_new.balance())
        try {
            println atm_new.withdraw(2600)
        } catch (Exception exception) {
            println(exception.message)
        }

        println(atm_new.balance())


    }
}
