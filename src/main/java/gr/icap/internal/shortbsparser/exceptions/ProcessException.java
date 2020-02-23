package gr.icap.internal.shortbsparser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class ProcessException extends RuntimeException {

    public ProcessException(String message) {
        super(message);
    }
}
