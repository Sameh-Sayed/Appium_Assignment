package appiumTask;

import appiumTask.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class StudentStepDefinition extends Base {

        @Given("I open the Student Kit app and login with student credentials")
        public void openAndLoginStudentKit() {
                driver.findElement(By.partialLinkText("Email")).sendKeys("test.student@mailinator.com ");
                driver.findElement(By.partialLinkText("Password")).sendKeys("Abc_123");
                driver.findElement(By.partialLinkText("Log in")).click();
        }

        @When("I navigate to the behavior section from the dashboard")
        public void navigateToBehaviorSection() {
                driver.findElement(By.partialLinkText("")).click();
                driver.findElement(By.partialLinkText("")).click();


        }

        @Then("I assert that the teacher-added behavior is present")
        public void assertTeacherAddedBehavior() {
            driver.findElement(By.partialLinkText("")).isDisplayed();
        }

}
