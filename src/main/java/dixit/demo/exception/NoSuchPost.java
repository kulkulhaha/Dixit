package dixit.demo.exception;

import lombok.Getter;

@Getter
public class NoSuchPost extends RuntimeException{
    public NoSuchPost() {
        super("존재하지 않는 게시글입니다");
    }

    public NoSuchPost( Throwable cause) {
        super("존재하지 않는 게시글입니다", cause);
    }
}
