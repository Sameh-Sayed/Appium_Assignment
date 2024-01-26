Feature: Teacher Kit App Behavior Tracking

  Scenario: Add behavior for a student and verify in Student Kit App
    Given I open the Teacher Kit app and login with credentials
    When I select the "Mobile Automation" course and go to the behavior tab
    And I select the student "Test student" and click on "take behavior"
    And I add a behavior with details
    Then I assert the success message appears

    Given I open the Student Kit app and login with student credentials
    When I navigate to the behavior section from the dashboard
    Then I assert that the teacher-added behavior is present