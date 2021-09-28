package helpers.models;

public class Form {

    private String customerFirstName;
    private String customerLastName;

    private Form() {
    }

    public static final class Builder {
        private String customerFirstName;
        private String customerLastName;


        public Builder customerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }

        public Builder customerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }

        public Form build() {
            if (customerFirstName.isEmpty()) {
                throw new IllegalStateException("First name cannot be empty");
            }
            if (customerLastName.isEmpty()) {
                throw new IllegalStateException("Last name cannot be empty");
            }

            Form form = new Form();
            form.customerFirstName = this.customerFirstName;
            form.customerLastName = this.customerLastName;
            return form;
        }
    }
    public static Builder builder() {
        return new Builder();
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }
}
