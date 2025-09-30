class BanknoteCell {
    final int denomination
    private int count

    BanknoteCell(int denomination) {
        this.denomination = denomination
        this.count = 0
    }

    void deposit(int banknotesCount) {
        count += banknotesCount
    }

    void withdraw(int banknotesCount) {
        count -= banknotesCount
    }

    int getCount() {
        count
    }

    int getCellAmount() {
        return denomination * count
    }

    BanknoteCell minus(int banknotesCount) {
        withdraw(banknotesCount)
        return this
    }

    BanknoteCell plus(int banknotesCount) {
        deposit(banknotesCount)
        return this
    }
}
