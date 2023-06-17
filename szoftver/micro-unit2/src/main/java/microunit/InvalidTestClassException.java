package microunit;

public class InvalidTestClassException extends RuntimeException{
    public InvalidTestClassException(Throwable cause){
        super(cause);
    }
}
