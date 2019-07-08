Feature: Check Link of Objective

  Background: Login successfully with valid WSM user account
    Given User navigate to Login page of Fgoal
    When User navigate to Login page of WSM
    And User enter valid account as user account
    And User enter valid password as password of user
    Then User should be access Fgoal successfully

  @link_view
  Scenario Outline: Verify that each Link To Objective displays Group, Objective, Key result and Quick Action button
    Given User creats new objective with valid "<objName>" and "<weight>"
    And User creats new "<linkto>" with "<group>" and "<existObj>"
    When User checks existing of Group, Objective, Key result and Quick Action button of "<linkto>"
    Then Group, Objective, Key result and Quick Action button are displayed

    Examples: 
      | objName                     | weight | linkto       | group     | existObj |
      | Testing Object have link to |      3 | linkto new 1 | section 1 | test     |

  @link_view
  Scenario Outline: Verify that corresponding Group screen displays when clicking on group link of any Link To
    Given User creats new objective with valid "<objName>" and "<weight>"
    And User creats new "<linkto>" with "<group>" and "<existObj>"
    When User clicks "<group>" link
    Then Corresponding "<group>" screen dislays

    Examples: 
      | objName                       | linkto       | group     | existObj |
      | Testing Object have link to 1 | linkto new 1 | section 1 | test     |

  @link_view
  Scenario Outline: Verify that corresponding Objective Details screen displays when clicking on Objective link of any Link To
    Given User creats new objective with valid "<objName>" and "<weight>"
    And User creats new "<linkto>" with "<group>" and "<existObj>"
    When User clicks "<existObj>" link
    Then corresponding "<existObj>" Details screen dislays

    Examples: 
      | objName                       | linkto       | group     | existObj |
      | Testing Object have link to 2 | linkto new 1 | section 1 | test     |

  @link_view
  Scenario Outline: Verify that Quick Action popup displays when clicking on Quick Action button of any Link To
    Given User creats new objective with valid "<objName>" and "<weight>"
    And User creats new "<linkto>" with "<group>" and "<existObj>"
    When User performs to open Quick Action popup
    Then Quick Action popup dislays

    Examples: 
      | objName                       | linkto       | group     | existObj |
      | Testing Object have link to 3 | linkto new 1 | section 1 | test     |

  @link_cancel
  Scenario Outline: Verify that Cancel link request dialog displays when clicking on Cancel option in Quick Action popup
    Given User creats new objective with valid "<objName>" and "<weight>"
    And User creats new "<linkto>" with "<group>" and "<existObj>"
    When User performs to open Quick Action popup
    And User performs to open Cancel link request dialog
    Then Cancel link request dialog displays

    Examples: 
      | objName                       | linkto       | group     | existObj |
      | Testing Object have link to 4 | linkto new 1 | section 1 | test     |

  @link_cancel
  Scenario Outline: Verify that Cancel link request dialog is closed, and Link To is not canceled when clicking on Close button in Cancel link request dialog
    Given User creats new objective with valid "<objName>" and "<weight>"
    And User creats new "<linkto>" with "<group>" and "<existObj>"
    When User performs to open Quick Action popup
    And User performs to open Cancel link request dialog
    And User performs to close Cancel link request dialog
    Then Cancel link request dialog is closed
    And "<linkto>" is existing

    Examples: 
      | objName                       | linkto       | group     | existObj |
      | Testing Object have link to 4 | linkto new 1 | section 1 | test     |

  @link_cancel
  Scenario Outline: Verify that Cancel link request dialog is closed, and Link To is not displayed when clicking on Cancel link request button in  Cancel link request dialog
    Given User creats new objective with valid "<objName>" and "<weight>"
    And User creats new "<linkto>" with "<group>" and "<existObj>"
    When User performs to open Quick Action popup
    And User performs to open Cancel link request dialog
    And User performs to confirm cancel link to
    Then Cancel link request dialog is closed
    And Message displays "<message>"
    And "<linkto>" is not existing

    Examples: 
      | objName                       | linkto       | group     | existObj | message                          |
      | Testing Object have link to 5 | linkto new 1 | section 1 | test     | You have rejected a link request |
