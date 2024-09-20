package id.briliando.phonebookapi.infra.exceptions;


import id.briliando.phonebookapi.app.base.Message;
import id.briliando.phonebookapi.app.base.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto handleRuntimeException(RuntimeException e) {
        log.error(e, e);
        return ResponseDto.error(new Message("RE001", e.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto handleNullPointerException(NullPointerException e) {
        log.error(e, e);
        return ResponseDto.error(new Message("NE001", "Ada kesalahan dalam sistem."));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto handleException(Exception e) {
        log.error(e, e);
        return ResponseDto.error(new Message("GE", "Ada kesalahan dalam sistem."));
    }
}
