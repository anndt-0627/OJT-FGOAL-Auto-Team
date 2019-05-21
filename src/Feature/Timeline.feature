Feature: Timeline
  Background:
  Scenario: Login successfully with valid WSM account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter email on Login WSM page
    And User enter password on Login WSM page
    Then User should be access Fgoal successfully

  @timeline @group
  Scenario: Verify default All value in Group dropdown list
    Given Admin is on Timeline page
    When Group dropdown is displayed on the Timeline page
    Then Default value on group dropdown list is All

  @timeline @group
  Scenario: Admin can filter result by select All group in the Group dropdown list
    Given Admin is on Timeline page
    When Group dropdown is displayed on the Timeline page
    And Admin performs select All in the Group dropdown list
    Then All activities is displayed on the Timeline page

  @timeline @group
  Scenario Outline: Admin can filter result by select group in the Group dropdown list
    Given Admin is on Timeline page
    When Group dropdown is displayed on the Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then All activities of Group is displayed as "<group>"
    Examples:
      | group |
      | Hang Group |

  @timeline @group
  Scenario Outline: No activities found displays when no activities in the Group
    Given Admin is on Timeline page
    When Group dropdown is displayed
    And Admin performs select group in Group dropdown list as "<group>"
    Then No activities found displays on the Timeline screen
    Examples:
      | group |
      | Group no activities |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user create an Objective
    Given User create an Objective in the Group as "<objective>" "<group>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have created objective is displayed as "<objective>"
    Examples:
      | objective | group |
      | New Objective by HangNT | Hang Group |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user Change Name an Objective
    Given User change name an Objective in the Group as "<objective>" "<group>" "<name>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have changed name objective is displayed as "<objective>" "<name>"
    Examples:
      | objective | group |name|
      | Objective by HangNT | Hang Group | New Name Objective updated|

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user Change Weight an Objective
    Given User change weight an Objective in the Group as "<objective>" "<group>" "<weight>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have changed weight objective is displayed as "<objective>" "<weight>"
    Examples:
      | objective | group |  weight |
      | Objective by HangNT | Hang Group |4 |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user delete an Objective
    Given User delete an Objective in the Group as "<objective>" "<group>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have deleted objective is displayed as "<objective>"
    Examples:
      | objective | group |
      | Objective by HangNT | Hang Group |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user Link Objective
    Given User Link Objective in the Group as "<objective>" "<group>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have linked Objective is displayed as "<objective>"
    Examples:
      | objective | group |
      | Objective by HangNT | Hang Group |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user Unlink Objective
    Given User Unlink Objective in the Group as "<objective>" "<group>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have unlink Objective is displayed as "<objective>"
    Examples:
      | objective | group |
      | Objective by HangNT | Hang Group |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user create a Key Result
    Given User create an Objective in the Group as "<key_result>" "<group>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have created Key Result is displayed as "<objective>"
    Examples:
      | objective | group |
      | Key Result by HangNT | Hang Group |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user change name Key Result
    Given User change name an Objective in the Group as "<key_result>" "<group>" "<name>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have changed name Key Result is displayed as "<objective>" "<name>"
    Examples:
      | objective | group | name |
      | Key Result by HangNT | Hang Group |New Name updated |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user change weight Key Result
    Given User change weight an Objective in the Group as "<key_result>" "<group>" "<weight>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have changed weight Key Result is displayed as "<objective>" "<weight>"
    Examples:
      | objective | group | weight |
      | Key Result by HangNT | Hang Group | 5 |

  @timeline @activities
  Scenario Outline: Verify that admin will get activities when having a user change target Key Result
    Given User change target an Objective in the Group as "<key_result>" "<group>" "<target>"
    When Admin is on Timeline page
    And Admin performs select group in Group dropdown list as "<group>"
    Then Activities just have changed target Key Result is displayed as "<objective>"  "<target>"
    Examples:
      | objective | group | target |
      | Key Result by HangNT | Hang Group | 65 |

