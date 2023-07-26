Feature: albums

  @albums
  Scenario: Verify album details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the "Your Music" link in the sidebar
    Then the  following albums and their details should be displayed
      | Name    | Author      | Count |
      | Hello   | duotech2023 | 0     |
      | Workout | duotech2023 | 0     |
      | Intense | duotech2023 | 0     |
      | Popular | duotech2023 | 0     |

   @temp
  Scenario: Default albums
    Given the user is on the homepage of the music streaming app
    When the user clicks on the "Browse" link in the sidebar
    Then the following albums should be displayed
      | Cruel Summer        |
      | Fenix               |
      | Werk                |
      | Marisa              |
      | Escape              |
      | Ultimatum           |
      | Oscillation         |
      | Clouds              |
      | I Am...Sasha Fierce |