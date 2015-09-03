package oopschen.archetype.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 业务消息处理
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
@ControllerAdvice public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) @ExceptionHandler(Exception.class)
    public void defaultHandler(Exception e) {
        LOGGER.error("exception", e);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN) @ExceptionHandler(LoginInvalidException.class)
    public void loginHandler(LoginInvalidException e) {
        // default do nothing
    }

}
