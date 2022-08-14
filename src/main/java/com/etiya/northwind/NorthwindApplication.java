package com.etiya.northwind;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.results.ErrorDataResult;


@SpringBootApplication
@RestControllerAdvice//Tüm uygulamada çalışması gerektiğini burada yazıyoruz.
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)//http bad request döner status code olarak
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		ErrorDataResult<Object> error = new ErrorDataResult<Object>(businessException.getMessage(),"BusinessException");
		return error;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation.Error");
		return errors;
	}

	
}
