package helpers.enums;

public class AlertEnums {

    public enum AlertMessageEnums {
        INVALID_EMAIL_ADDRESS_ERROR("Invalid email address."),
        EMAIL_ADDRESS_REQUIRED_ERROR("An email address required."),
        INVALID_PASSWORD_ERROR("Invalid password."),
        PASSWORD_REQUIRED_ERROR("Password is required."),
        AUTHENTICATION_FAILED_ERROR("Authentication failed."),
        FORGOT_PASSWORD_CONFIRMATION("A confirmation email has been sent to your address: "),
        NO_ACCOUNT_REGISTER_ERROR("There is no account registered for this email address."),
        TERMS_OF_SERVICE_AGREE_ERROR("You must agree to the terms of service before continuing."),
        ORDER_IS_COMPLETE ("Your order on My Store is complete.");

        private final String alertMessage;

        AlertMessageEnums(String alertMessage) {
            this.alertMessage = alertMessage;
        }

        public String getAlertMessage() {
            return this.alertMessage;
        }
    }
}
