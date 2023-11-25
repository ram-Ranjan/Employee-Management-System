package com.ramRanjan.EmployeeManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ramRanjan.EmployeeManagementSystem.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	
	
	public class ApplicationHandler extends ResponseEntityExceptionHandler {

//		@Override
//		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//				HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//			List<ObjectError> list = ex.getAllErrors();
//			HashMap<String, String> hashMap = new HashMap<>();
//			for (ObjectError error : list) {
//				String fieldName = ((FieldError) error).getField();
//				String message = error.getDefaultMessage();
//				hashMap.put(fieldName, message);
//			}
//			return new ResponseEntity<Object>(hashMap, HttpStatus.BAD_REQUEST);
//		}

		@ExceptionHandler(EmployeeNotFoundByIdException.class)
		public ResponseEntity<ResponseStructure<String>> emailAlreadyExistingForApplicant(
				EmployeeNotFoundByIdException ex) {
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Employee doesn't exist!!");
			responseStructure.setData(ex.getMessage());
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		}

		
		@ExceptionHandler(UniqueTeamsNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> idNotFoundForApplicantException(
				UniqueTeamsNotFoundException ex) {
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Unique teams doesn't exist!!");
			responseStructure.setData(ex.getMessage());
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		}

}
}
