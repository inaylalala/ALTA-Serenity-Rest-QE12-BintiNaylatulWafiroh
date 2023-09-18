Feature: Get single user not found
#  Positive
  @Tugas
  Scenario:Get single user not found with valid data
    Given Get single user not found with more than twelve 23
    When Send request get single user not found
    Then Status code should be 404
    And Validate get single resource json schema "Get/GetSingleUserNotFoundSchema.json"
# Negative
  @Tugas
  Scenario: Get single user not found with invalid id
    Given Get single user not found with less than twelve 11
    When Send request get single user not found
    Then Status code should be 200
