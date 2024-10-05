package md.practice.bloggingapi.exception;

import java.io.Serial;

public class PostsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public PostsException(String message) {
        super(message);
    }
    public PostsException() {
        super();
    }
}
