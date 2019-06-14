Feature: Simple PDF

  Background:
    Given User opens library and selects "Autotest" box

  Scenario:
    Given User opens Simple PDF popup
    When User clicks Cancel
    Then Popup is closed

  Scenario: Download Simple PDF files
    Given User orders Simple PDF
    When User download 1up-PDF
    And User download 1up-CF2
    Then Downloaded files are not empty

