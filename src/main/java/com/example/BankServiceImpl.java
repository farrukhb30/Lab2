package com.example;

public class BankServiceImpl implements BankService {
    @Override
    public void pay(String id, double amount) {
        if(id.equals("John"))
            throw new RuntimeException();
    }
}
