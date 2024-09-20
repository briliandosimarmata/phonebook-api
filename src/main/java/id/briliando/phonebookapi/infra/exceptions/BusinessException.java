package id.briliando.phonebookapi.infra.exceptions;

public class BusinessException extends RuntimeException {

    protected String code;
    protected Object[] arguments;

    public BusinessException(String code, Object... arguments) {
        super(code);
        this.code = code;
        this.arguments = arguments;
    }
}
