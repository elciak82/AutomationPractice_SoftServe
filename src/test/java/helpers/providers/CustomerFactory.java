package helpers.providers;

import helpers.models.Customer;

public class CustomerFactory {

    private static final String NUMERIC_STRING = "1234567890";
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";
    private static final String suffix = generateSuffix();

    public String randomNumericString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String randomAlphaString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_STRING.length());
            builder.append(ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String generateSuffix() {
        return randomAlphaString(6);
    }

    public String generateRandomEmail() {
        return "email@" + suffix + ".com";
    }

    public String generateRandomPassword() {
        return "pass" + suffix;
    }

    public String generateRandomUserFirstName() {
        return "FirstName" + suffix;
    }

    public String generateRandomUserLastName() {
        return "LastName" + suffix;
    }

    public String generateRandomCompany() {
        return "Company" + suffix;
    }

    public String generateRandomAddress() {
        return "Address" + suffix;
    }

    public String generateRandomAddressLine2() {
        return "Address2" + suffix;
    }

    public String generateRandomCity() {
        return "City" + suffix;
    }

    public String generateRandomZip() {
        return "12345";
    }

    public String generateRandomPhoneNumber() {
        return "123456789";
    }

    public String generateRandomMobileNumber() {
        return "600600600";
    }

    public String generateRandomAddressAlias() {
        return "Alias" + suffix;
    }

    public Customer getCustomerToRegister_Required() {
        String firstName = generateRandomUserFirstName();
        String lastName = generateRandomUserLastName();
        String password = generateRandomPassword();
        String address = generateRandomAddress();
        String city = generateRandomCity();
        String zip = generateRandomZip();
        String mobilePhone = generateRandomMobileNumber();
        String addressAlias = generateRandomAddressAlias();

        return Customer.builder()
                .customerFirstName(firstName)
                .customerLastName(lastName)
                .customerPassword(password)
                .customerAddress(address)
                .customerCity(city)
                .customerZip(zip)
                .customerMobilePhone(mobilePhone)
                .customerAddressAlias(addressAlias)
                .build();
    }
}
