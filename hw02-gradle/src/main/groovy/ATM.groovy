class ATM {
    final SortedMap <Integer, BanknoteCell> atm

    ATM(List<Integer> denominations) {
        this.atm = new TreeMap<Integer,BanknoteCell> ({
            a, b -> b <=> a
        })
        denominations.each {denomination ->
            atm.put(denomination, new BanknoteCell(denomination))
        }
    }

    void deposit(int denomination, int count) {
        atm[denomination] + count
    }

    ATM plus(Map<Integer, Integer> cash) {
        cash.each {key, value ->
            deposit(key, value)
        }
        return this
    }

    ATM minus(int requestedAmount) {
        withdraw(requestedAmount)
        return this
    }

    String toString(){
        return "ATM balance: ${balance()} RUB"
    }

    int balance() {
        def sum = atm.values().sum {
            it.cellAmount
        }
        return sum
    }

    Map<Integer, Integer> withdraw(int requestedAmount) {
        if (balance() < requestedAmount) {
            throw new IllegalArgumentException("No enough cash")
        }

        def withdrawCash =[:]
        int delta = requestedAmount

        atm.each {it ->
            int availableBanknotes = it.value.count
            if (availableBanknotes == 0) {
                return
            }
            if (requestedAmount < it.key) {
                return
            }
            int banknotesAmount = (delta / it.key)
            int getBanknotesAmount = 0
            if (banknotesAmount > 0) {
                if (availableBanknotes > banknotesAmount) {
                    getBanknotesAmount = banknotesAmount
                } else {
                    getBanknotesAmount = availableBanknotes
                }
            }
            if (getBanknotesAmount > 0) {
                withdrawCash[it.key] = getBanknotesAmount
                delta -= it.key * getBanknotesAmount
            }
        }

        if (delta != 0) {
            throw new IllegalArgumentException("No suitable banknotes")
        }

        withdrawCash.each { key, value ->
            atm[key] -= value
        }

        return withdrawCash
    }
}
