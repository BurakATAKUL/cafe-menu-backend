package com.cafe.cafe_menu.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResoruceNotFoundException extends RuntimeException {
  public ResoruceNotFoundException(String message) {
    super(message);
  }
}
