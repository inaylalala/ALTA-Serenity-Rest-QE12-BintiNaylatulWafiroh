Feature: Get delayed response
#  Scenario Positive
  @Tugas
  Scenario Outline: Get delayed response
    Given Get delayed response with delayed time <time>
    When Send request get delayed response
    Then Status code should be 200
    And Validate get delayed response users json schema "Get/GetDelayedResponseSchema.json"
    Examples:
      | time |
      | -3   |
      | 0    |
      | 3    |
#   Scenario Negative 1
  @Tugas
  Scenario: Get delayed response with alphabet
    Given Get delayed with time was "nayla"
    When Send request get delayed response
    Then Status code should be 400
#    Scenario negative 2
  @Tugas
  Scenario: Get delayed response with special char
    Given Get delayed with time was "$^^*%"
    When Send request get delayed response
    Then Status code should be 400




