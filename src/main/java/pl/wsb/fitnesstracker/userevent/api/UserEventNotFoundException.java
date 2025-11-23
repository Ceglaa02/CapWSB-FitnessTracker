package pl.wsb.fitnesstracker.userevent.api;

public class UserEventNotFoundException extends RuntimeException {
    public UserEventNotFoundException(String message) {
        super(message);
    }
}
