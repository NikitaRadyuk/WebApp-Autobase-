package by.radyuk.myautobase.model.service.Exception;

public class ServiceException extends Exception{
    public ServiceException(){}

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
