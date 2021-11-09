package helpers.models;

public class Customer {

    private String customerFirstName;
    private String customerLastName;
    private String customerPassword;
    private String customerEmail;
    private String customerCompany;
    private String customerAddress;
    private String customerAddress2;
    private String customerCity;
    private String customerZip;
    private String customerAdditionalInfo;
    private String customerHomePhone;
    private String customerMobilePhone;
    private String customerAddressAlias;


    public Customer() {
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public String getCustomerAdditionalInfo() {
        return customerAdditionalInfo;
    }

    public String getCustomerHomePhone() {
        return customerHomePhone;
    }

    public String getCustomerMobilePhonePhone() {
        return customerMobilePhone;
    }

    public String getCustomerAddressAlias() {
        return customerAddressAlias;
    }

    public static final class Builder {
        private String customerFirstName;
        private String customerLastName;
        private String customerPassword;
        private String customerEmail;
        private String customerCompany;
        private String customerAddress;
        private String customerAddress2;
        private String customerCity;
        private String customerZip;
        private String customerAdditionalInfo;
        private String customerHomePhone;
        private String customerMobilePhone;
        private String customerAddressAlias;


        public Builder customerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }

        public Builder customerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder customerPassword(String customerPassword) {
            this.customerPassword = customerPassword;
            return this;
        }

        public Builder customerCompany(String customerCompany) {
            this.customerCompany = customerCompany;
            return this;
        }

        public Builder customerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder customerAddress2(String customerAddress2) {
            this.customerAddress2 = customerAddress2;
            return this;
        }

        public Builder customerCity(String customerCity) {
            this.customerCity = customerCity;
            return this;
        }

        public Builder customerZip(String customerZip) {
            this.customerZip = customerZip;
            return this;
        }

        public Builder customerAdditionalInfo(String customerAdditionalInfo) {
            this.customerAdditionalInfo = customerAdditionalInfo;
            return this;
        }

        public Builder customerHomePhone(String customerHomePhone) {
            this.customerHomePhone = customerHomePhone;
            return this;
        }

        public Builder customerMobilePhone(String customerMobilePhone) {
            this.customerMobilePhone = customerMobilePhone;
            return this;
        }

        public Builder customerAddressAlias(String customerAddressAlias) {
            this.customerAddressAlias = customerAddressAlias;
            return this;
        }

        public Customer build() {
            if (customerFirstName.isEmpty()) {
                throw new IllegalStateException("First name cannot be empty");
            }
            if (customerLastName.isEmpty()) {
                throw new IllegalStateException("Last name cannot be empty");
            }

            Customer customer = new Customer();
            customer.customerFirstName = this.customerFirstName;
            customer.customerLastName = this.customerLastName;
            customer.customerPassword = this.customerPassword;
            customer.customerEmail = this.customerEmail;
            customer.customerCompany = this.customerCompany;
            customer.customerAddress = this.customerAddress;
            customer.customerAddress2 = this.customerAddress2;
            customer.customerCity = this.customerCity;
            customer.customerZip = this.customerZip;
            customer.customerAdditionalInfo = this.customerAdditionalInfo;
            customer.customerHomePhone = this.customerHomePhone;
            customer.customerMobilePhone = this.customerMobilePhone;
            customer.customerAddressAlias = this.customerAddressAlias;
            return customer;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
