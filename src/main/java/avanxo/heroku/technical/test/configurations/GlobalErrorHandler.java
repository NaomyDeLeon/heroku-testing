/*
 */
package avanxo.heroku.technical.test.configurations;

import avanxo.heroku.technical.test.data.procesors.exceptions.InvalidIdException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author pytagoraz
 */
@RestController
@ControllerAdvice
public class GlobalErrorHandler
        extends ResponseEntityExceptionHandler
        implements java.io.Serializable {

    @ExceptionHandler(InvalidIdException.class)
    protected ResponseEntity<Object> handleConflict(
            InvalidIdException ex,
            WebRequest request) {
        return handleExceptionInternal(ex, null,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
