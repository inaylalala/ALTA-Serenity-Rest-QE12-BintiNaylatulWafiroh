Feature: Post Login Unsuccessful
#  Positive
  @Tugas
  Scenario: Login with valid data
    Given Post login unsuccessful with json "Post/PostLoginUnsuccessful.json"
    When Send request post login unsuccessful
    Then Status code should be 400
    And Validate register unsuccessful JSON schema "Post/PostLoginUnsuccesfulSchema.json"
#  Negative
  @Tugas
  Scenario: Login with email and password
    Given Post login with json "Post/PostLoginSuccessful.json"
    When Send request post login successful
    Then Status code should be 200
    And Validate login success JSON schema "Post/PostLoginSuccessfulSchema.json"