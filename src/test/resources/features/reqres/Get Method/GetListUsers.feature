Feature: Get list user
#  GetListUserPositive
    @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200
    And response body page should be <page>
    And Validate get list users json schema "Get/GetListUsersSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |
      | 3    |

#  GetListUserNegative
  @Tugas
  Scenario: Get list user with parameter with page alphabet
    Given Get list users with alphabet "nayla"
    When Send request get list users
    Then Status code should be 400
  @Tugas
  Scenario: Get list user with parameter page with special char
    Given Get list users with special char "$^&%&%"
    When Send request get list users
    Then Status code should be 400



