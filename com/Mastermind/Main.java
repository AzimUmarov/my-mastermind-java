package com.Mastermind;
import java.util.*;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        String code = Validation.createRandomNumber();
        int attempts = 10;

        try {
            for (int i = 0; i < args.length; i++) {
                if (Objects.equals(args[i], "-c")) {
                    if (Validation.checkRightInput(args[i + 1]))
                        code = args[i + 1];
                    else
                        throw new ArithmeticException("Invalid secret code or attempts");
                }
                if (Objects.equals(args[i], "-t")) {
                    if (Validation.isNumeric(args[i + 1]))
                        attempts = Integer.parseInt(args[i + 1]);
                    else
                        throw new ArithmeticException("Invalid secret code or attempts");
                }
            }
        }
        catch (Exception e) {
//            System.out.println("Invalid secret code or attempts");
        }
//        myMastermind(code,attempts);
        System.out.println("code: " + code + " attempts " + attempts);

    }
}

class Validation {
    public static boolean checkRightInput(String buf)
    {
        for(int i = 0;i < buf.length(); i++){
            int n = buf.charAt(i);
            if(n < 48 || n > 55 || i > 3)
                return false;
        }
        return true;
    }
    static boolean isNumeric(String str) {
        for (char c : str.toCharArray())
            if (!Character.isDigit(c)) return false;

        return true;
    }
    static String createRandomNumber(){
        StringBuilder code = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < 4; i++){
            int int_random = rand.nextInt(8);
            code.append(int_random);
        }
        return code.toString();
    }
}