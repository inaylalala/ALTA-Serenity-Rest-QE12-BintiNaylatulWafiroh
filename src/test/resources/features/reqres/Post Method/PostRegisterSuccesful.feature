Feature: Post register successful
#  Positive
  @Tugas
  Scenario: Login with valid email and password
    Given Post register with json "Post/PostRegisterSuccessful.json"
    When Send request post register successful
    Then Status code should be 200
    And Validate login success JSON schema "Post/PostRegisterSuccessfulSchema.json"
#  Negative
  @Tugas
  Scenario Outline: Register with invalid email or password
    Given Post register with invalid email "<email>" or password "<password>"
    When Send request post register successful
    Then Status code should be 400
    And Validate register success JSON schema "Post/PostRegisterUnsuccessfulSchema.json"
    Examples:
      | email                | password             |
      | 1537392              | inaylalala@gmail.com |
      | 1537392              |                      |
      |                      | inaylalala@gmail.com |
      | inaylalala@email,com | 1537392              |
      |                      |                      |