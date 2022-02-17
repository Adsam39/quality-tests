package com.teaching.project.banking.domain

data class Account(val iban: String, var balance: Double = 0.0) {

    init {
        if(!Regex("^FR[0-9]{25}").matches(iban)){
            throw RuntimeException("IBAN invalide")
        }
    }

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        if(balance - amount > 0){
            balance -= amount
        }
        else {
            throw RuntimeException("Pas assez d'argent sur le compte")
        }
    }

    fun transfer(receiver: Account, amount: Double) {
        if (amount < 0) {
            throw RuntimeException("Votre compte à un solde négatif")
        }
        if (balance - amount > 0){
            receiver.deposit(amount)
            withdraw(amount)
        }
        else {
            throw RuntimeException("CHEH")
        }
    }
}