package springboot.junit.exception;

public class UrlNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer errorCode;

    private String message;

    public UrlNotFoundException(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
