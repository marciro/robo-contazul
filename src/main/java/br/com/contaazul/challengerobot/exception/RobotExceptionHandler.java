package br.com.contaazul.challengerobot.exception;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RobotExceptionHandler {


	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Erro ao processar requisição";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	private ResponseEntity<Object> handleExceptionInternal(RuntimeException ex, String bodyOfResponse,
			HttpHeaders httpHeaders, HttpStatus status, WebRequest request) {
		String join = StringUtils.join(Arrays.asList(bodyOfResponse,ex.getMessage()),":");
		return new ResponseEntity<Object>(join, status); 
	}

}
