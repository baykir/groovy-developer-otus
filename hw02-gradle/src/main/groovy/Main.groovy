class Main {
    static void main(String[] args) {
        ATM atm = new ATM([10, 50, 100, 500, 1000, 2000, 5000])

        atm.deposit(5000, 1)
        atm.deposit(100, 3)
        atm.deposit(10, 100)

        try {
            println atm - 260000
        } catch (Exception exception) {
            println(exception.message)
        }

        try {
            atm - 101
        } catch (Exception exception) {
            println(exception.message)
        }

        println atm

        atm + [50:15, 2000:3]
        println atm

        atm - 1000
        println atm
    }
}
