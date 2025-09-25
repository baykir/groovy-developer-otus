class Main {
    static void main(String[] args) {
        ATM atm = new ATM()
        try {
            atm + [10:2, 500:1, 2000:10, 5000:3]
            println atm
            atm - 10001
            println atm
        } catch (Exception exception) {
            println exception.message
        }

    }
}
