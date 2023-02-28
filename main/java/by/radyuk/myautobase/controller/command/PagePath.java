package by.radyuk.myautobase.controller.command;

public class PagePath {

    public static final String LOGIN_PAGE = "/pages/login.jsp";
    public static final String USER_PAGE = "/pages/userpage.jsp";
    public static final String MAIN_PAGE = "/index.jsp";
    public static final String SIGNUP_PAGE = "/pages/register.jsp";
    public static final String SHOW_FREE_VOYAGE_PAGE = "/pages/voyages.jsp";
    public static final String ADD_VOYAGES_PAGE = "/pages/addVoyage.jsp";

    public static final String VERIFY_EMAIL_PAGE = "pages/verify_email.jsp";
    public static final String ERROR_404_PAGE = "pages/error/error404.jsp";
    public static final String ERROR_500_PAGE = "pages/error/error500.jsp";

    private final String address;

    PagePath(String address) {
        this.address = address;
    }

    /**
     * Gets address.
     *
     * @return the address of page
     */
    public String getAddress() {
        return address;
    }
}
