package mobile_automation.exercise;
import mobile_automation.exercise.BaseTest;
import mobile_automation.exercise.pageObjects.android.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertThrows;

public class SearchTest extends BaseTest {

	@BeforeMethod
	public void preSetup()
	{
		HomePage homePage = new HomePage(driver);
		homePage.setActivity();
	}

	@Test(dataProvider="playerData")
	public void searchPlayerTest(String teamName, String choiceName, String subTabName) throws MalformedURLException, InterruptedException{

		// Arrange SomeClass someObject = new SomeClass();

		// Act and Assert Exception thrown = assertThrows(Exception.class, () -> someObject.someMethod()); // No exception was thrown, so execute the method again if (thrown == null) { someObject.someMethod(); // Do some other assertions or verifications here } }
		HomePage homePage = new HomePage(driver);
		// Looks for getting started page and performs actions
		homePage.getStarted();
		// Looks for allow location modal and performs actions
		homePage.allowLocation();

		//Looks for selecting favorite team page and performs actions
		homePage.selectYourFavoriteTeam(teamName);

		//Below steps are to search the league or player
		//Select the search bar
		homePage.clickSearchBarView();
		
		//Search the team 
		homePage.searchChoice(choiceName);
				
		//Mark the team as favorite
		homePage.selectChoice(choiceName);

		//Assert if the player or team name displayed is correct.
		Assert.assertEquals(choiceName, homePage.getPlayerName());
		
		//Select the stats button
		homePage.selectSubTab(subTabName);

		//Assert if the player or team name displayed is correct.
		Assert.assertEquals(subTabName, homePage.getSubTabText(subTabName));

		//Go Back to Previous Page
		homePage.clickNavigateBackButton();
				
	}
	@Test(dataProvider = "teamData")
	public void searchTeamTest(String teamName, String choiceName, String subTabName) throws MalformedURLException, InterruptedException{

		HomePage homePage = new HomePage(driver);

		// Looks for getting started page and performs actions
		homePage.getStarted();

		// Looks for allow location modal and performs actions
		homePage.allowLocation();

		//Looks for selecting favorite team page and performs actions
		homePage.selectYourFavoriteTeam(teamName);

		//Below steps are to search the league or player

		//Select the search bar
		homePage.clickSearchBarView();

		//Search the team
		homePage.searchChoice(choiceName);

		//Mark the team as favorite
		homePage.selectChoice(choiceName);

		//Assert if the player or team name displayed is correct.
		Assert.assertEquals(choiceName, homePage.getTeamName());

		//Select the stats button
		homePage.selectSubTab(subTabName);

		//Assert if the player or team name displayed is correct.
		Assert.assertEquals(subTabName, homePage.getSubTabText(subTabName));

		//Go Back to Previous Page
		homePage.clickNavigateBackButton();
	}
	@DataProvider(name="playerData")
	public Object[][] getPlayerData(){
		return new Object[][]{{"Toronto Blue Jays","Stephen Curry","Stats"},{"Toronto Blue Jays","Stephen Curry","Info"}};
	}

	@DataProvider(name="teamData")
	public Object[][] getTeamData(){
		return new Object[][]{{"Toronto Blue Jays","Toronto Blue Jays","Schedule"}};
	}

}
