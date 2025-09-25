class ATM {
    private final Map <Integer, Integer> banknotes = [:]


    void deposit(Map <Integer, Integer> cash) {
        cash.each {key, value ->
            banknotes[key] = (banknotes.getOrDefault(key, 0) + value)
        }
    }

    Map <Integer, Integer> withdraw(int amount) {
        if(balance() < amount) {
            throw new IllegalArgumentException("No enough cash")
        }
        List sortedBanknotes = banknotes.keySet().sort().reverse()

        def withdrawCash = [:]

        int delta = amount
        sortedBanknotes.each {element ->
            int availableBanknote = banknotes.get(element) ?: 0
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
                throw new IllegalArgumentException("No suitable banknotes")
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

    ATM plus (Map<Integer, Integer> cash){
        //Переопределенный метод для более удобного внесения
        deposit(cash)
        return this
    }

    Map<Integer, Integer> minus(int amount){
        //Переопределенный метод для более удобного снятия
        return withdraw(amount)
    }

    @Override
    String toString() {
        return "ATM{balance=${balance()}, banknotes=${banknotes}"
    }
}
