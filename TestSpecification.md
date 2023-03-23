## Test Specifications 

For this challenge I used the android build  version - 23.3.0. Two scenarios were created for this challenge

1. Search the player
   * Go to the home page
   * Select the Get Started Button
   * Select the Continue Button
   * Select Allow Location if exists 
   * Select your favorite team - Used TestNG dataprovider here to pass the data
   * Search for the player - Used TestNG dataprovider here to pass the data
   * Verify the page loaded is correct
   * Select the sub tab 
   * Verify the sub tab loaded is correct
   * Go back to previous page 
    Also used TestNG dataprovider to run the test with multiple datasets.
2. Search the team 
   * Go to the home page
   * Select the Get Started Button
   * Select the Continue Button
   * Select Allow Location if exists
   * Select your favorite team - Used TestNG dataprovider here to pass the data
   * Search for the player - Used TestNG dataprovider here to pass the data
   * Verify the page loaded is correct
   * Select the sub tab
   * Verify the sub tab loaded is correct
   * Go back to previous page

## Why this Framework
I chose Appium because it supports cross-platform testing and can interact with native and hybrid apps. I chose TestNG because it provides annotations, assertions and ability to run tests parallely. The page object model to organize the code and make it more reusable and maintainable. Data driven testing to provide different inputs for each feature and verify different scenarios. 
