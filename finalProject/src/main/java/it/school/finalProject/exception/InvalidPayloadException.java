package it.school.finalProject.exception;

public class InvalidPayloadException extends RuntimeException{

    public InvalidPayloadException(String message){
        super (message);
    }
}
