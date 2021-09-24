package helpers.enums;

public class PageTitleEnums {

    public enum TitlesEnums {
        AUTHENTICATION_PAGE("Login - My Store"),
        CONTACT_US_PAGE("Contact us - My Store"),
        DRESSES_PAGE("Dresses - My Store"),
        HOME_PAGE("My Store"),
        TSHIRT_PAGE("T-shirts - My Store"),
        WOMEN_PAGE("Women - My Store"),
        MY_ACCOUNT_PAGE("My account - My Store");

        private final String pageTitle;

        TitlesEnums(String pageTitle) {
            this.pageTitle = pageTitle;
        }
        public String getPageTitle() {
            return this.pageTitle;
        }
    }
}
