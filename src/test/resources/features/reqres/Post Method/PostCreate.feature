Feature: Post Create
#  Positive
  @Latihan
  Scenario: Post create a new user with valid json
    Given Create new user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201
    And Response body name was "Nayla" and job was "QE Engineer"
    And Validate create a new user JSON schema "Post/CreateUsersSchema.json"

#  Negative 1
    @Tugas
  Scenario Outline: Post create a new user without name or job
    Given Create new user without name "<name>" or job "<job>"
    When Send request post create new user
    Then Status code should be 400
    Examples:
      | name  | job    |
      | nayla |        |
      |       | doctor |
      |       |        |
#   Negative 2
    @Tugas
    Scenario: Post create user with name was numeric and job was special char
    Given Post create user with name "asdasda" and job "%$#%^"
    When Send request post create user
    Then Status code should be 400

