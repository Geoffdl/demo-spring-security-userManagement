package fr.diginamic.demospringsecurityusermanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
      @ExceptionHandler(Exception.class)
      public String handleIllegalArgumentException(Exception e) {
            return "redirect:/view/register";
      }

      @ExceptionHandler(ProblemException.class)
      public String handleIllegalArgumentException(ProblemException e) {
            return "redirect:/view/register";
      }
}
