Feature:Get single user resource
#  Positive
  @Tugas

  Scenario Outline: Get single resource with valid data
    Given Get single resource with value <id>
    When Send request get single resource
    Then Status code should be 200
    And Validate get single resource json schema "Get/GetSingleResourceSchema.json"
    Examples:
      | id |
      | 2  |
      | 12 |
# Negative
  @Tugas
  Scenario Outline: Get single resource with exit id on parameter page
    Given Get single resource with special char "<exit id>"
    When Send request get single resource
    Then Status code should be 404
    And Validate get single resource json schema "Get/GetSingleResourceNotFoundSchema.json"
    Examples:
      | exit id              |
      | inaylalala@gmail.com |
      | inaylalala           |
      | @$%^&#@              |
      | 500                  |