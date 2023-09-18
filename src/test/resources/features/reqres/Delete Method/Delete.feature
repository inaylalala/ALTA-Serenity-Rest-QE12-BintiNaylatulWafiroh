Feature: Delete Method
#  DeletePositive
    @Latihan
  Scenario Outline: Delete a user with valid user id
    Given Delete a user with valid user id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |

#  DeleteNegative
    @Tugas
  Scenario Outline: Delete a user with exit user id
    Given Delete a user with exit user id "<id>"
    When Send request delete exit user id
    Then Status code should be 400 Bad Request
    Examples:
      | id                   |
      | ^&%nayla             |
      | &$%^#&               |
      | inaylalala@gmail.com |
      | https://reqres.in/   |




