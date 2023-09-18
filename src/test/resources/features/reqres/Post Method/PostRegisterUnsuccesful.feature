Feature: Post Register Unsuccessful
#  Positive
  @Tugas
  Scenario: Register with email
  Given Post register unsuccessful with json "Post/PostRegisterUnsuccessful.json"
  When Send request post register unsuccessful
  Then Status code should be 400
  And Validate register unsuccessful JSON schema "Post/PostRegisterUnsuccessfulSchema.json"
#  Negative
  @Tugas
  Scenario: Login with email and password
    Given Post register with json "Post/PostRegisterSuccessful.json"
    When Send request post register successful
    Then Status code should be 200
    And Validate login success JSON schema "Post/PostRegisterSuccessfulSchema.json"