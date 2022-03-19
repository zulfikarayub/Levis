Feature: Zero bank header functionality

  @Tc01
  Scenario Outline: zero bank home page internal tab

    Given User launch the URL '<URL>' successfully
    And verify page title
    When verify page nav bar
    Then verify home page internal tab


    Examples:
      | URL       |
      | Zero_bank |

  @Tc02
  Scenario Outline: zero bank online banking  page internal tab

    Given User launch the URL '<URL>' successfully
    And verify page title
    When click on online banking tab
    Then verify online bank internal tab


    Examples:
      | URL       |
      | Zero_bank |

  @Tc03
  Scenario Outline: zero bank feedback  page internal tab

    Given User launch the URL '<URL>' successfully
    And verify page title
    When click on feedback tab
    And verify name field validation
    And verfiy email field validation
    And verify subject field validation
    And verify success message is displayed



    Examples:
      | URL       |
      | Zero_bank |





