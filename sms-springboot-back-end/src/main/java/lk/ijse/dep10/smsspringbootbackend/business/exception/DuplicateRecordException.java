package lk.ijse.dep10.smsspringbootbackend.business.exception;

public class DuplicateRecordException extends BOException{
    public DuplicateRecordException(String message){
        super(message);
    }

    public DuplicateRecordException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateRecordException(Throwable cause) {
        super(cause);
    }

    public DuplicateRecordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
