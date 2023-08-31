Feature: Automate the DemoWebShop
  @Registration
  Scenario Outline: User first able to Register the DemoWebShop
    Given User launch the Application
    When User is able to give the PersonalDetails and Create the Password such as Gender and  "<FirstName>"
    And and "<LastName>" "<Email>" and  "<Password>" "<ConfirmPassword>"
    Then Click on the Register button and Verify the Confirm message.
    And Close the Application.
    Examples:
      | FirstName| LastName| Email              | Password   | ConfirmPassword |
      | Ramesh   | Aravind | Shivaji009@gmail.com| Shivaji009| Shivaji009      |

  @Login
  Scenario Outline: User is able to Login the DemoWebShop
    Given User launch the Application
    When after Registration Completed User able to login with same Register valid Credentials
    And "<Email>" and "<Password>"
    Then Verify the Login Email
    And Close the Application.
    Examples:
      | Email              | Password |
      | Charli777@gmail.com| Charli777|

  @AddToCart
  Scenario Outline: User is able to Add the Product to Cart and Verify it
    Given User launch the Application
    When User is select "<MainCategorie>" from "<Product>" select the "<Item>"
    And applying the Filtersfrom DropDowns "<FilterName1>" "<FilterValue1>" and "<FilterName2>" "<FilterValue2>"
    And user is apply's the Filters Click on AddtoCart
    | FilterName  | FilterValue  |
    |<FilterName3>|<FilterValue3>|
    |<FilterName4>|<FilterValue4>|
    |<FilterName5>|<FilterValue5>|
    And user is going through CheckoutProcess
    Then Verify Order Confirm
    And Close the Application.
    Examples:
      | MainCategorie| Product | Item                   | FilterName1 | FilterValue1 | FilterName2 | FilterValue2 | FilterName3 | FilterValue3     | FilterName4 | FilterValue4             | FilterName5 | FilterValue5            |
      | Computers    | Desktops| Build your own computer| Processor   | 2.2 GHz Intel| RAM         | 8GB          | HDD         | 400 GB  [+100.00]| OS          | Windows 10  [+60.00]     | Software    | Acrobat Reader  [+10.00]|