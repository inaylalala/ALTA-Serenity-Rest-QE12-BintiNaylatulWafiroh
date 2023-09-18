Feature: Get single user
#  Positive
  @Tugas
Scenario: Get single user with valid parameter page
Given Get single user with valid parameter page 2
When Send request get single user
Then Status code should be 200
And Validate get single user json schema "Get/GetSingleUserSchema.json"
#    Negative
  @Tugas
  Scenario: Get single user with parameter with page alphabet
    Given Get single user with alphabet "nayla"
    When Send request get single user
    Then Status code should be 404
  @Tugas
  Scenario: Get list user with parameter page with special char
    Given Get single user with special char "$^&%&%"
    When Send request get single user
    Then Status code should be 404
