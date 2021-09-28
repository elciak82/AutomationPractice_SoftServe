package helpers.models;

public class Form {

    private String firstName;
    private String lastName;

    public static final class Builder {
        private String firstName;
        private String lastName;


        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Form build() {
            if (firstName.isEmpty()) {
                throw new IllegalStateException("First name cannot be empty");
            }
            if (lastName.isEmpty()) {
                throw new IllegalStateException("Last name cannot be empty");
            }

            Form form = new Form();
            form.firstName = this.firstName;
            form.lastName = this.lastName;
            return form;
        }
    }
    public static Builder builder() {
        return new Builder();
    }

}
