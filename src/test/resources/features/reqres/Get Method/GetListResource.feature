Feature: Get list resource
#  Positive
  @Tugas
  Scenario: Get list resource with unknown page
    Given Get list resource with unknown page
    When  Send request get list resource
    Then Status code should be 200
    And Validate get list resource json schema "Get/GetListResourceSchema.json"

