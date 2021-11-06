package helpers.enums;

public class StatesEnums {

    public enum CustomerStateEnums {
        ALABAMA("1"),
        ALASKA("2"),
        ARIZONA("3"),
        ARKANSAS("4"),
        CALIFORNIA("5"),
        COLORADO("6")
        ;

        private final String state;

        CustomerStateEnums(String state) {
            this.state = state;
        }

        public String getState() {
            return this.state;
        }
    }
}
