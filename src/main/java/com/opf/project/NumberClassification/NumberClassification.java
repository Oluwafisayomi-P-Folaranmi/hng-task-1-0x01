package com.opf.project.NumberClassification;

import java.util.ArrayList;
import java.util.List;

public class NumberClassification {

    /**
     * Member Fields
     */
    private Integer number = 0;

    /**
     * Member Constructor
     */
    public NumberClassification(Integer number) {

        this.number = number;
    }

    /**
     * Getters
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Member Methods
     */
    // is prime
    // + checks if it is a prime number
    public boolean isPrime() {
        // Corner cases
        if (number <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        if (number <= 3) {
            return true; // 2 and 3 are prime numbers
        }

        // Check if number is divisible by 2 or 3
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        // Check for factors starting from 5 and skipping even numbers
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    // is perfect
    // + check if it is a perfect square
    public boolean isPerfect() {
        int sum = 0;
        int num = this.getNumber();
        for(int i =1; i < num; i++){
            if(num % i == 0){
                sum+= i;
            }
        }
        return sum == num;
    }

    // properties
    // + check if it is an Armstrong number
    public boolean isArmStrong(int number){
        int sum = 0;
        int temp = number;
        int digits = (int) Math.log10(number) + 1;

        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == number;
    }
    // + check for properties
    public List<String> getProperties() {
        int num = this.getNumber();
        List<String> properties = new ArrayList<>();
        if(isArmStrong(num)){
            properties.add("armstrong");
        }
        if (num % 2 == 0){
            properties.add("even");
        }
        else {
            properties.add("odd");
        }
        return properties;
    }

    // digit sum
    // + find the sum of the digits in the number
    public Integer digitSum() {
        int num = this.getNumber();
        int sum = 0;
        while(num != 0){
            sum += (num % 10);
            num = num / 10;
        }
        return sum;
    }

    // fun fact
    // + anything funny
    public String funFact() {
        List<Integer> digits = this.showDigits();
        if(isArmStrong(this.number)){
            return "'" + this.number + "' is an Armstrong number because: " +
                    makeStringMessage();
        }
        else {
            return "not an Armstrong";
        }
    }

    // The digits
    // + It retrieves the digits in the number
    public List<Integer> showDigits() {
        int number = this.getNumber();
        int sum = 0;
        List<Integer> digits = new ArrayList<>();
        while(number != 0){
            digits.add(number % 10);

            number = number / 10;
        }

        return digits;
    }

    // Make String text
    // + For example: 9^4 + 4^4 + 7^4 + 4^4
    public StringBuilder makeStringMessage() {
        List<Integer> digits = this.showDigits();
        StringBuilder text = new StringBuilder();
        Double armstrong = 0.0;

        for (int i = 0; i < digits.size(); i++) {
            int size = digits.size();
            int digit = digits.get(i);
            if (i < size - 1)
                text.append(digit + "^" + size + " + ");
            else
                text.append(digit + "^" + size + " ");

            armstrong += Math.pow(digit, size);

        }
        text.append("= " + armstrong);

        return text;
    }
}
