Feature: Patch Update
#  Positive
  @Tugas
  Scenario Outline: Patch user with input username and job
    Given Update user with id 2 username <username> and  job <job>
    When Send request patch update
    Then Status code should be 200
    And Validate patch update user JSON schema "Patch/PatchUpdateSchema.json"
    Examples:
      | username | job         |
      | nayla    | admin       |
      | irfan    | businessman |
#  Negative
  @Tugas
  Scenario Outline: Patch user without input username or job
    Given Update user id 2 without input username <username> and  job <job>
    When Send request patch update
    Then Status code should be 404
    Examples:
      | username | job         |
      | nayla    |             |
      |          | businessman |
      |          |             |