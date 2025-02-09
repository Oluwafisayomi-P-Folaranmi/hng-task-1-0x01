package com.opf.project.service;

// import lombok.RequiredArgsConstructor;
import com.opf.project.response.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class ClassifyController {

    private final NumberClassificationService numberClassificationService;

    public ClassifyController(NumberClassificationService numberClassificationService) {
        this.numberClassificationService = numberClassificationService;
    }

    @GetMapping("/classify-number")
    public ResponseEntity<?> classify(@RequestParam int number) {
        return numberClassificationService.classifyNumber(number);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "Alphabet", true
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
