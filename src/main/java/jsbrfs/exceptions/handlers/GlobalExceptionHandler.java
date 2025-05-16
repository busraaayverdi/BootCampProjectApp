package jsbrfs.exceptions.handlers;

import jsbrfs.exceptions.details.BusinessProblemDetails;
import jsbrfs.exceptions.details.InternalServerProblemDetails;
import jsbrfs.exceptions.types.BusinessException;
import jsbrfs.exceptions.types.InternalServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //http isteği atınca araya dahil eder
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException) {
        BusinessProblemDetails details = new BusinessProblemDetails();
        details.setDetail(businessException.getMessage());
        return details;
    }
    @ExceptionHandler({InternalServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerProblemDetails handleInternalServerException(InternalServerException internalServerException) {
        InternalServerProblemDetails details = new InternalServerProblemDetails();
        details.setDetail(internalServerException.getMessage());
        return details;
    }

}
