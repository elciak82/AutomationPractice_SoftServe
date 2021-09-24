package helpers.enums;

public class ErrorMessageEnums {

    public enum ErrorEnums {
        INVALID_EMAIL_ADDRESS("Invalid email address."),
        EMAIL_ADDRESS_REQUIRED("An email address required."),
        INVALID_PASSWORD("Invalid password."),
        PASSWORD_REQUIRED("Password is required.");

        private final String errorMessage;

        ErrorEnums(String pageTitle) {
            this.errorMessage = pageTitle;
        }
        public String getErrorMessage() {
            return this.errorMessage;
        }
    }
}
