class ATM {
    private final Map <Integer, Integer> banknotes = [:]


    void deposit(Map <Integer, Integer> cash) {
        cash.each {key, value ->
            println "$key: $value"
            banknotes[key] = value
        }
    }

    Map <Integer, Integer> withdraw(int amount) {
        if(balance() < amount) {
            return null
        }
        List sortedBanknotes = banknotes.keySet().sort().reverse()
        sortedBanknotes.each { element ->
            println element
        }

        def withdrawCash = [:]

        int delta = amount
        sortedBanknotes.each {element ->
            int availableBanknote = banknotes.get(element)
            if (availableBanknote == 0) {
                return
            }
            if (amount < element){
                return
            }
            int banknotesAmount = delta / element
            int getBanknotesAmount = 0
            if (banknotesAmount > 0) {
                if (availableBanknote > banknotesAmount) {
                    getBanknotesAmount = banknotesAmount
                } else {
                    getBanknotesAmount = availableBanknote
                }
            }
            if (getBanknotesAmount > 0) {
                withdrawCash[element] = getBanknotesAmount
                delta -= element * getBanknotesAmount
            }
            if (delta != 0) {
                return null
            }
        }

        withdrawCash.each {key, value ->
            banknotes[key] -= value
        }
        return withdrawCash
    }

    int balance(){
        int sum = 0
        banknotes.each { key, value ->
            sum += key * value
        }
        return sum

    }
}
