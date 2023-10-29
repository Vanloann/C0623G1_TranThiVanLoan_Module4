package com.example.bookrent.config;

import com.example.bookrent.utils.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler extends Throwable {

    @org.springframework.web.bind.annotation.ExceptionHandler(MyException.class)
    public ModelAndView showErrorMess(Exception e) {
//        String message = "Your renting quantity cannot exceed the remaining quantity of this kind of book";
        return new ModelAndView("error", "message", e.getMessage());
    }
}
