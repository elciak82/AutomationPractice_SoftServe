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

    public String customerRandomEmail() {
        return "email@" + suffix + ".com";
    }

    public String customerRandomPassword() {
        return "pass" + suffix;
    }

    public String customerRandomFirstName() {
        return "FirstName" + suffix;
    }

    public String customerRandomLastName() {
        return "LastName" + suffix;
    }

    public String customerRandomCompany() {
        return "Company" + suffix;
    }

    public String customerRandomAddress() {
        return "Address" + suffix;
    }

    public String customerRandomAddressLine2() {
        return "Address2" + suffix;
    }

    public String customerRandomCity() {
        return "City" + suffix;
    }

    public String customerRandomZip() {
        return "12345";
    }

    public String customerAdditionalInfo() {
        return "Additional_info" + suffix;
    }

    public String customerRandomPhoneNumber() {
        return "123456789";
    }

    public String customerRandomMobileNumber() {
        return "600600600";
    }

    public String customerRandomAddressAlias() {
        return "Alias" + suffix;
    }

    public Customer getCustomerToRegister_required() {
        String firstName = customerRandomFirstName();
        String lastName = customerRandomLastName();
        String password = customerRandomPassword();
        String address = customerRandomAddress();
        String city = customerRandomCity();
        String zip = customerRandomZip();
        String mobilePhone = customerRandomMobileNumber();
        String addressAlias = customerRandomAddressAlias();

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

    public Customer getCustomerToRegister_all() {
        String firstName = customerRandomFirstName();
        String lastName = customerRandomLastName();
        String password = customerRandomPassword();
        String company = customerRandomCompany();
        String address = customerRandomAddress();
        String addressLine2 = customerRandomAddressLine2();
        String city = customerRandomCity();
        String zip = customerRandomZip();
        String additionalInfo = customerAdditionalInfo();
        String phoneNumber = customerRandomPhoneNumber();
        String mobilePhone = customerRandomMobileNumber();
        String addressAlias = customerRandomAddressAlias();

        return Customer.builder()
                .customerFirstName(firstName)
                .customerLastName(lastName)
                .customerPassword(password)
                .customerCompany(company)
                .customerAddress(address)
                .customerAddress2(addressLine2)
                .customerCity(city)
                .customerZip(zip)
                .customerAdditionalInfo(additionalInfo)
                .customerHomePhone(phoneNumber)
                .customerMobilePhone(mobilePhone)
                .customerAddressAlias(addressAlias)
                .build();
    }

    public String getCustomerFirstNameLastName(){
        return customerRandomFirstName() + " " + customerRandomLastName();
    }
}
