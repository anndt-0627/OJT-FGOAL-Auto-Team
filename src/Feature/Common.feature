Feature: Test function common for Header - Footer - Slide Menu - Search

  Scenario Outline: Verify that content of Header
    Given User is on Home screen
    Then User should see <item> on header is displayed correctly
    Examples:
      | item           |
      | Title Fgoal    |
      | Search textbox |
      | Avatar icon    |

  Scenario: Verify that content of Footer
    Given User is on Home screen
    Then User should see Footer text is displayed correctly

  Scenario: Verify that navigate to Home screen after user clicking on Fgoal title
    Given User is on Home screen
    When User navigates to Organization Chart screen
    And User clicks on Fgoal title
    Then User navigates to Home screen

  Scenario: Verify that "Search group name or staff name" is displayed as placeholder of Search textbox
    Given User is on Home screen
    Then Search group name or staff name is displayed as placeholder of Search textbox

  Scenario Outline: Verify that show suggested value contain search keyword when user inputs search keyword into search textbox
    Given User is on Home screen
    When User inputs search keyword into search textbox as "<search_keyword>"
    Then Show suggested value contain "<search_keyword>" when user inputs search search_keyword into search textbox
    Examples:
      | search_keyword |
      | Doan Ngoc Vu   |

  Scenario Outline: Verify that navigates to Group detail when user chooses group at search textbox
    Given User is on Home screen
    When User inputs search keyword into search textbox as "<search_keyword>"
    And User performs select group
    Then Navigates to Group detail of selected group
    Examples:
      | search_keyword |
      | Doan Ngoc Vu   |

  Scenario: Verify that User information pop up is displayed when user clicks on Avatar icon
    Given User is on Home screen
    When User clicks on Avatar icon
    Then User information pop up is displayed

  Scenario Outline: Verify that content of User information pop up
    Given User is on Home screen
    When User clicks on Avatar icon
    Then User should see <item> on User information pop up
    Examples:
      | item               |
      | Email address link |
      | My Profile link    |
      | Log out button     |

  Scenario Outline: Verify that content of Slide Menu of Admin Account
    Given User is on Home screen
    Then User should see <item> item on Slide Menu of Admin Account
    Examples:
      | item               |
      | Dashboard          |
      | Units              |
      | Years Plan         |
      | Organization Chart |
      | My Groups          |
      | Pin Groups         |
      | Timeline           |
      | Users              |
      | Logout             |

  Scenario Outline: Verify that navigates to corresponding screen when clicks on item at Slide Menu of Admin Account
    Given User is on Home screen
    Then User clicks on <item_menu> item at Slide Menu of Admin Account
    Then Navigates to <screen> correctly
    Examples:
      | item_menu          | screen                    |
      | Dashboard          | Dashboard screen          |
      | Units              | Units screen              |
      | Years Plan         | Years Plan screen         |
      | Organization Chart | Organization Chart screen |
      | Timeline           | Timeline screen           |
      | Users              | Users screen              |

  Scenario: Verify that navigates to Login screen when clicks on Log out item at Slide Menu of Admin Account
    Given User is on Home screen
    Then User clicks on Log out item at Slide Menu of Admin Account
    Then Navigates to Login screen

  Scenario: Verify that show all groups belong to logged user when clicks on My Groups item at Slide Menu of Admin Account
    Given User is on Home screen
    Then User clicks on My Groups item at Slide Menu of Admin Account
    Then Show all groups belong to logged user

  Scenario: Verify that show all groups have pinned when clicks on Pin Groups item at Slide Menu of Admin Account
    Given User is on Home screen
    Then User clicks on Pin Groups item at Slide Menu of Admin Account
    Then Show all groups have pinned


