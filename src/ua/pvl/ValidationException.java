package ua.pvl;

public class ValidationException extends Exception {

    public ValidationException() {
    }

    public ValidationException(String msg) {
        super(msg);
    }

    public String getMessage() {
        return "You have to put correct input Path";
    }

}