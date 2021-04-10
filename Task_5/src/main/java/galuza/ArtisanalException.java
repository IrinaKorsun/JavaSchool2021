package galuza;

public class ArtisanalException extends Exception {
    private ArtisanalErrorCode errorCode;

    public ArtisanalException(ArtisanalErrorCode errorCode, Throwable cause) {
        super(errorCode.getArtisanalErrorCode(), cause);
        this.errorCode = errorCode;
    }

    public ArtisanalException(ArtisanalErrorCode errorCode) {
        super(errorCode.getArtisanalErrorCode());
        this.errorCode = errorCode;
    }

    public ArtisanalException(ArtisanalErrorCode errorCode, String param) {
        super(String.format(errorCode.getArtisanalErrorCode(), param));
        this.errorCode = errorCode;
    }

    public ArtisanalException(Throwable cause) {
        super(cause);
    }

    public ArtisanalErrorCode getArtisanalErrorCode() {
        return errorCode;
    }
}
