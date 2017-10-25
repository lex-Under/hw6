package epam.homework.hw4.taskOne;

public class CacheIsNotInjectedException extends RuntimeException {

    public CacheIsNotInjectedException() {
        super();
    }

    public CacheIsNotInjectedException(String s) {
        super(s);
    }
}
