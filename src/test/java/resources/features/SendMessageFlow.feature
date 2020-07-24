# new feature
# Tags: optional

Feature: A description

  Scenario: Send message flow
    Given I access yourlogo website
    And I click on contact us
    And I choose "Customer service" from subject heading
    And I enter email address
    And I enter message "I need help"
    And I press send button
    Then I see proper message "Your message has been successfully sent to our team."