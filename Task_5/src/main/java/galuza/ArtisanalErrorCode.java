package galuza;

public enum ArtisanalErrorCode {
    STACK_OVERFLOW("Stack overflow"),
    QUEUE_IS_EMPTY("Queue is empty"),
    STACK_IS_EMPTY("stack is empty"),
    NO_SUCH_ELEMENT_EXCEPTION("no such element");


    private String message;

    ArtisanalErrorCode(String message) {
        this.message = message;
    }

    public String getArtisanalErrorCode() {
        return message;
    }

    public void setArtisanalErrorCode(String message) {
        this.message = message;
    }
}
