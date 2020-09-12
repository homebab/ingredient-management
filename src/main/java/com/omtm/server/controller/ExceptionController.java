package com.omtm.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.NoSuchElementException;

// based on https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc#controller-based-exception-handling
@ControllerAdvice
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

//    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")  // 409
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<String> conflict(DataIntegrityViolationException e) {
        logger.error("" + e.getMessage());
        return new ResponseEntity<>("" + e.getMessage(), HttpStatus.CONFLICT);
        // Nothing to do
    }

    // Specify name of a specific view that will be used to display the error:
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public ResponseEntity<String> databaseError(Exception e) {
        // Nothing to do.  Returns the logical view name of an error page, passed
        // to the view-resolver(s) in usual way.
        // Note that the exception is NOT available to this view (it is not added
        // to the model) but see "Extending ExceptionHandlerExceptionResolver"
        // below.
        return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    // @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such element") // 404
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<String> notFound(NoSuchElementException e) {
        logger.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
