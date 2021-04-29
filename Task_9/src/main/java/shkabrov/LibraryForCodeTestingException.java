package shkabrov;

/**
 * Класс исключений LibraryForCodeTesting
 */
public class LibraryForCodeTestingException extends Exception {
    private LibraryForCodeTestingErrorCode libraryForCodeTestingErrorCode;

    public LibraryForCodeTestingException(LibraryForCodeTestingErrorCode libraryForCodeTestingErrorCode) {
        this.libraryForCodeTestingErrorCode = libraryForCodeTestingErrorCode;
    }

    /**
     * @return код ошибки
     */
    public LibraryForCodeTestingErrorCode getErrorCode() {
        return libraryForCodeTestingErrorCode;
    }
}
