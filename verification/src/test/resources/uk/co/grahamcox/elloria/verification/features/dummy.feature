Feature: Dummy
  Scenario Outline: Addition
    Given that I start with <Start>
    When I add <Add>
    Then I get <Expected>

    Examples:
      | Start | Add | Expected |
      | 1     | 2   | 3        |

    @wip
    Examples:
      | Start | Add | Expected |
      | 1     | 3   | 4        |
