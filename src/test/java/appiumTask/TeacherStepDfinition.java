package appiumTask;
import appiumTask.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TeacherStepDfinition extends Base {

        @Given("I open the Teacher Kit app and login with credentials")
        public void openAndLoginTeacherKit() {
                driver.findElement(By.partialLinkText("Email")).sendKeys("Test.teacher@mailinator.com");
                driver.findElement(By.partialLinkText("Password")).sendKeys("Abc_123");
                driver.findElement(By.partialLinkText("Log in")).click();



        }

        @When("I select the {string} course and go to the behavior tab")
        public void selectCourseAndNavigateToBehaviorTab(String courseName) {
            // Appium code to select course and navigate to the behavior tab
        }

        @And("I select the student {string} and click on {string}")
        public void selectStudentAndTakeBehavior(String studentName, String behaviorButton) {
            // Appium code to select student and click on behavior button
        }

        @And("I add a behavior with details")
        public void addBehaviorWithDetails() {
        }

        @Then("I assert the success message appears")
        public void assertSuccessMessage() {
            driver.findElement(By.xpath("")).isDisplayed();
        }
    }


