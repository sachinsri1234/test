Feature: Login Feature for the fish shop app

Scenario Outline: Successful login when user logs in with valid credentials

 Given User is on Fish Store login page
 When User enters "<username>" in username input field
 And User enters "<password>" in the password input field
 And User clicks on login button
 Then User has been successfully redirected to the homepage

 Examples:
 
 |username | password|
 |j2ee | j2ee|


 Scenario: Add the product to cart and checkout
 Given User has been successfully redirected to the homepage
 When User selects the desired product

 |Fish | FI-SW-01 | EST-1 |

 And User clicks on the add to cart button
 And User clicks on proceed to checkout
 And User clicks on continue button
 And User clicks on confirm button
 Then User is able to make the successful purchase


 Scenario: Add the product to cart and checkout

 Given User has been successfully redirected to the homepage
 When User selects the desired product

 |	Birds	| AV-CB-01 | EST-18 |

 And User clicks on the add to cart button
 And User clicks on proceed to checkout
 And User clicks on continue button
 And User clicks on confirm button
 Then User is able to make the successful purchase
