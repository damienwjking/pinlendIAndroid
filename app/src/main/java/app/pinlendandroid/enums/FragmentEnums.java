package app.pinlendandroid.enums;

/**
 * Created by ntnhuy on 19/03/2016.
 */
public enum FragmentEnums {
    HOME("HOME"),
    SIGN_UP("SIGN_UP"),
    SECURITY_VERIFICATION("SECURITY_VERIFICATION"),
    ENTER_CODE("ENTER_CODE"),
    LOGIN("LOGIN");

    private String fragmentName;

    FragmentEnums(String name) {
        this.fragmentName = name;
    }

    public String getFragmentName() {
        return this.fragmentName;
    }
}
