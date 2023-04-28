package dixit.demo.exception;

public class NoSuchHeader extends RuntimeException {
    public NoSuchHeader() {
        super("존재하지 않는 헤더입니다.");
    }

    public NoSuchHeader(Throwable cause) {
        super("존재하지 않는 헤더입니다.", cause);
    }
}
