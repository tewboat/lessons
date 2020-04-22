package com.example.finalproject.repository;

import java.util.Random;

public class HashCodeGenerator {
    public String generateID(){
        Random random = new Random();
        int high = 100;
        int low = 1;
        int q = 37;
        int b = random.nextInt(high - low) + low;
        String code = "";
        String abc = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < 5; i++){
            code += abc.charAt(random.nextInt(26));
        }
        String hashCode = q * b + code;
        return hashCode;
    }
}
