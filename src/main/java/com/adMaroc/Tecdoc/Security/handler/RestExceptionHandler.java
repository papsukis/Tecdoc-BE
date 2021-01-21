package com.adMaroc.Tecdoc.Security.handler;

import com.adMaroc.Tecdoc.Security.Exceptions.*;
import com.adMaroc.Tecdoc.Security.Models.ApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @Override
        protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            String error = "Malformed JSON request";
            return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
        }

        private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
            return new ResponseEntity<Object>(apiError, apiError.getStatus());
        }

        //other exception handlers below
    @ExceptionHandler(InternalServerException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            InternalServerException ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);

        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            BadRequestException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EmailAlreadyExistsException ex,HttpStatus status) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            ResourceNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            UsernameAlreadyExistsException ex) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }


    @ExceptionHandler(IncorrectOTPCodeException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            IncorrectOTPCodeException ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            BadCredentialsException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

}


