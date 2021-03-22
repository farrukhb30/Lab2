package com.example;

public class TestBankService implements BankService {

    @Override
    public void pay(String id, double amount) {
        if(id.equals("Exec006"))
            throw new RuntimeException();

    }
}
