package com.vaika.api.model.exception;

public class BadRequestException extends ApiException {
  public BadRequestException(String message) {
    super(ExceptionType.CLIENT_EXCEPTION, message);
  }
}
