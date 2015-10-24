package org.braidner.blog.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author KuznetsovNE/ 09.09.2015.
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleResourceNotFoundException(ResourceNotFoundException ex)
    {
        return ex.getMessage();
    }



    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleBadRequestException(BadRequestException ex)
    {
        return ex.getMessage();
    }

}
