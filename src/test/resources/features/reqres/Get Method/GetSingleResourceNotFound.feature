Feature: Get single resource not found
#  Positive
  @Tugas
  Scenario: Get single resource not found with valid data
    Given Get single resource not found with more than twelve 23
    When Send request get single resource not found
    Then Status code should be 404
    And Validate get single resource json schema "Get/GetSingleResourceNotFoundSchema.json"
#  Negative
  @Tugas
  Scenario: Get single resource not found with invalid id
    Given Get single resource not found with less than twelve 11
    When Send request get single resource not found
    Then Status code should be 200
    And Validate get single resource json schema "Get/GetSingleResourceSchema.json"
