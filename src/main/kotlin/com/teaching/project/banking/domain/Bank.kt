package com.teaching.project.banking.domain

data class Bank(val accounts: MutableMap<String, Account> = mutableMapOf()) {

    fun register(account: Account) {
        accounts.put(account.iban, account)
    }

    fun transfer(sender: Account, receiver: Account, amount: Double) {
        if(sender.balance - amount > 0){
            sender.transfer(receiver, amount)
        }
        else {
            throw RuntimeException("Compte ne peut pas être créé")
        }
    }

    fun dashboard() {
        print(this)
    }
}
