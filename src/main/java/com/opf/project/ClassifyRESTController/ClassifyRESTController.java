package com.opf.project.ClassifyRESTController;

import org.springframework.http.HttpStatus;
import com.opf.project.ExceptionHandler.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.opf.project.NumberClassification.NumberClassification;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClassifyRESTController {

    /**
     * Retrieves a number from user and
     * return the properties.
     * @return numberClassified
     */
    @GetMapping("/classify-number/{number}")
    public ResponseEntity<?> classifyNumber(@PathVariable String number) {

        /*
         * Check for exception in the path variable
         * + if number is a character other than 1 - infinity
         */
        if (!isValidInteger(number)) {
            // If it's not a valid integer, return a 400 error response
            return new ResponseEntity(new ErrorDetails("alphabet", true), HttpStatus.BAD_REQUEST);
        }

        /*
         * The record to store the information 
         * of the classified number
         */
        try {
            Integer num = Integer.parseInt(number);
            HashMap<String, Object> numberClassified = new HashMap<>();

            /*
             * Check if integer is negative
             */
            if (num < 0) {
                throw new NumberFormatException();
            }
            
            NumberClassification numberClassification = new NumberClassification(num);
            numberClassified.put("number", numberClassification.getNumber());
            numberClassified.put("is_prime", numberClassification.isPrime());
            numberClassified.put("is_perfect", numberClassification.isPerfect());
            numberClassified.put("properties", numberClassification.getProperties());
            numberClassified.put("digit_sum", numberClassification.digitSum());
            numberClassified.put("fun_fact", numberClassification.funFact());
            
            return new ResponseEntity(numberClassified, HttpStatus.OK)
        }
        catch(NumberFormatException ex) {
            return new ResponseEntity(new ErrorDetails("alphabet", true), HttpStatus.BAD_REQUEST);
        }
    }

    // Helper method
    private boolean isValidInteger(String str) {
        try {
            // Attempt to parse the string into an integer
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            // If a NumberFormatException occurs, it's not a valid integer
            return false;
        }
    }
}
