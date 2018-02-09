Feature: Word Wrap

  Scenario: Wrapping an empty line
    Given An empty line
    And a 10 columns page
    When the line is wrapped
    Then the result is an empty line

  Scenario: Wrapping an line in a longer line
    Given The following line Hello
    And a 10 columns page
    When the line is wrapped
    Then the result is:
      | Hello |

  Scenario: Wrapping an line with no space in a shorter line
    Given The following line Hello
    And a 3 columns page
    When the line is wrapped
    Then the result is:
      | Hel |
      | lo  |

  Scenario: Wrapping an line multiple times with no space in a shorter line
    Given The following line BraveNewWorld
    And a 3 columns page
    When the line is wrapped
    Then the result is:
      | Bra |
      | veN |
      | ewW |
      | orl |
      | d   |

  Scenario: Wrapping an line with a space in a shorter line
    Given The following line Hello world
    And a 7 columns page
    When the line is wrapped
    Then the result is:
      | Hello |
      | world |

  Scenario: Wrapping an line with several spaces per line in a shorter line
    Given The following line Hello brave new world
    And a 18 columns page
    When the line is wrapped
    Then the result is:
      | Hello brave new |
      | world           |
