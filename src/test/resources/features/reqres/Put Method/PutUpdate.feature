Feature: Put Update user
#  Positive
    @Latihan
  Scenario Outline: Put update user with valid json and user id
    Given Update user with valid json "<jsonFile>" and user id <id>
    When Send request put update user
    Then Status code should be 200
    And Response put update body name was "<name>" and job was "<job>"
    And Validate put update user JSON schema "Put/PutUpdateUsersSchema.json"
    Examples:
      | id | jsonFile         | name           | job       |
      | 1  | UpdateUser.json  | Nayla Update   | QE Edit   |
      | 2  | UpdateUser2.json | Nayla Update 2 | QE Edit 2 |
      | 3  | UpdateUser3.json | Nayla Update 3 | QE Edit 3 |

#  Positive
  @Tugas
  Scenario: Put update user with name was numeric and job was special char
    Given Put update user with id 1, name "asdasda" and job "%$#%^"
    When Send request put update user
    Then Status code should be 200
    And Validate put update user  JSON schema "Put/PutUpdateUsersSchema.json"

#  Negative
    @Tugas
    Scenario Outline: Put update user without input name or job
    Given Put update user with id 2 without name "<name>" or job "<job>"
    When Send request put update user
    Then Status code should be 400
    Examples:
      | name  | job    |
      | nayla |        |
      |       | doctor |
      |       |        |
  @PutUpdateNegative @Tugas
  Scenario: Put update user with query parameter
    Given Put update user with query parameter ""
    When Send request put update user
    Then Status code should be 400
    And Validate put update user  JSON schema "Put/PutUpdateUsersSchema.json"



