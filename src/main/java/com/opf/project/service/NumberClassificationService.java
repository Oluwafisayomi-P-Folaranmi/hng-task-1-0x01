package com.opf.project.service;

import com.opf.project.response.ApiResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;


@Service
public class NumberClassificationService {

    private final Logger logger = LoggerFactory.getLogger(NumberClassificationService.class);


    public ResponseEntity<?> classifyNumber(int number) {
        RestTemplate restTemplate = new RestTemplate();
        String numberApi = "http://numbersapi.com/"+ number + "/math";
        String response = restTemplate.getForObject(numberApi , String.class);
        List<String> prop = new ArrayList<String>();
        if (armstrong(number)){
            prop.add("armstrong");
        }
        prop.add(evenNumber(number) ? "even" : "odd");
        ApiResponse apiResponse = new ApiResponse(
                number,is_prime_number(number),is_perfect_number(number)
                ,prop, digit_sum(number), response
        );
        assert response != null;
        logger.info(String.valueOf(apiResponse));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    private boolean is_prime_number(int number) {
        if(number < 2){
            return false;
        }
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
    public static boolean is_perfect_number(int number) {
        var factorSum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                factorSum += i;
                if(i != number/i) factorSum += number/i;
            }
        }
        return (
                factorSum == number);
    }

    private int digit_sum (int number) {
        int sum = 0;
        int armstrong=0;
        while (number > 0) {
            sum = (sum + number % 10);
            armstrong += (int) pow(sum, 3);
            number /= 10;
        }
        return sum;
    }
    public boolean armstrong (int number) {
        int sum = 0;
        int originalNumber = number;
        int numDigits = String.valueOf(number).length();
        while (number > 0) {
            int digit =  number % 10;
            sum += (int) pow(digit, numDigits);
            number /= 10;
        }
        return sum==originalNumber;
    }

    private boolean evenNumber(int number) {
        return number % 2 == 0;
    }
}