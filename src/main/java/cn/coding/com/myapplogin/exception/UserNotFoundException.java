package cn.coding.com.myapplogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**@Author JosephCrypto
 *@Create 2022-41-2/15/22 9:41 PM
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrack) {
        super(message, cause, enableSuppression, writableStackTrack);
    }

    //Add Exception handler for developer
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException (UserNotFoundException exception) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(),exception.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    //To Catch ant Exception
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException (Exception exc) {
        CustomErrorResponse error = new CustomErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        exc.getMessage(),
        System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
