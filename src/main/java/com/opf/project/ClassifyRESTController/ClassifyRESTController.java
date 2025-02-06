package com.opf.project.ClassifyRESTController;

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
    public Map<String, Object> classifyNumber(@PathVariable Integer number) {

        // The record to store the information
        // of the classified number.
        HashMap<String, Object> numberClassified = new HashMap<>();
        NumberClassification numberClassification = new NumberClassification(number);
        numberClassified.put("number", numberClassification.getNumber());
        numberClassified.put("is_prime", numberClassification.isPrime());
        numberClassified.put("is_perfect", numberClassification.isPerfect());
        numberClassified.put("properties", numberClassification.getProperties());
        numberClassified.put("digit_sum", numberClassification.digitSum());
        numberClassified.put("fun_fact", numberClassification.funFact());

        return numberClassified;
    }
}
