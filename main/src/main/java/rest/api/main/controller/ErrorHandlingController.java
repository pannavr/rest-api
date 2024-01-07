package rest.api.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rest.api.main.model.modelDTO.ResponseDataDTO;

@RestControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDataDTO<String>> commonException(Exception exception){
        HttpStatus status;
        if(exception instanceof HttpRequestMethodNotSupportedException){
            status = HttpStatus.METHOD_NOT_ALLOWED;
        }else if(exception instanceof MissingServletRequestParameterException || exception instanceof HttpMessageNotReadableException || exception.getMessage().contains("ParseException")){
            status = HttpStatus.BAD_REQUEST;
        }else if(exception instanceof HttpMediaTypeNotSupportedException){
            status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        }else{
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status)
                .body(ResponseDataDTO.<String>builder().status(status.toString()).data(exception.getMessage()).build());
    }
}
