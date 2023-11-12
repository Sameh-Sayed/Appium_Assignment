package appiumTask;

import org.testng.annotations.Test;

public class TestLogin extends Base {

    @Test
    public void loginWithValidCredentials() {
        performLogin("standard_User", "secret_sauce");
        assertSuccessfulLogin();
        // Add assertion for successful login
    }
    @Test
    public void loginWithInvalidUsername() {
        performLogin("wrong_User", "secret_sauce");
        assertFailedLogin("Username and password do not match any user in this service.");
        // Add assertion for error message displayed
    }
    @Test
    public void loginWithInvalidPassword() {
        performLogin("standard_User", "secret_sauceaa");
        assertFailedLogin("Username and password do not match any user in this service.");
        // Add assertion for error message displayed
    }
    @Test
    public void loginWithEmptyUsername() {
        performLogin("", "secret_sauce");
        assertFailedLogin("Username is required");
        // Add assertion for error message displayed
    }
    @Test
    public void loginWithEmptyPassword() {
        performLogin("standard_User", "");
        assertFailedLogin("Password is required");
        // Add assertion for error message displayed
    }
    @Test
    public void loginWithIncorrectCredentials() {
        performLogin("wrong_User", "secret_sauceaa");
        assertFailedLogin("Username and password do not match any user in this service.");
        // Add assertion for error message displayed
    }
}