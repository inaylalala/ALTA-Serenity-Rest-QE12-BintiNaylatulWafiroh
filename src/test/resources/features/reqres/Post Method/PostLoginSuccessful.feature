Feature: Post login successful
#Positive
  @Tugas
  Scenario: Login with valid email and password
    Given Post login with json "Post/PostLoginUser.json"
    When Send request post login successful
    Then Status code login success should be 200 OK
    And Validate login success JSON schema "Post/PostLoginSuccessfulSchema.json"
# Negative
  @Tugas
  Scenario Outline: Login with invalid email or password
    Given Post login with invalid email "<email>" or password "<password>"
    When Send request post login successful
    Then Status code should be 400
    And Validate login success JSON schema "Post/PostLoginUnsuccesfulSchema.json"
    Examples:
      | email                | password             |
      | 1537392              | inaylalala@gmail.com |
      | 1537392              |                      |
      |                      | inaylalala@gmail.com |
      | inaylalala@email,com | 1537392              |
      |                      |                      |

