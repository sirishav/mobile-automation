package mobile_automation.exercise.pageObjects.android;

import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	
	public HomePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(id="com.fivemobile.thescore:id/action_button_text")
	private WebElement actionButton;

	@FindBy(id="com.fivemobile.thescore:id/btn_allow")
	private WebElement allowLocationButton;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_one_time_button")
	private WebElement allowOneTimeButton;
	
	@FindBy(id="com.fivemobile.thescore:id/search_bar_placeholder")
	private WebElement searchPlaceholder;
	
	@FindBy(id="com.fivemobile.thescore:id/search_src_text")
	private WebElement searchInputBox;
	
	@FindBy(xpath="//*[contains(@resource-id,'com.fivemobile.thescore:id/txt_name') and contains(@text,'%s')]")
	private WebElement searchChoice;
	
	@FindBy(id="com.fivemobile.thescore:id/btn_primary")
	private WebElement continueButton;
	
	@FindBy(id="com.fivemobile.thescore:id/dismiss_modal")
	private WebElement dismissModalButton;
	
	@FindBy(id="com.fivemobile.thescore:id/search_bar_text_view")
	private WebElement searchBarView;
	
	@FindBy(xpath="//*[contains(@content-desc, '%s')]")
	private WebElement subTab;
	
	@FindBy(id="com.fivemobile.thescore:id/txt_player_name")
	private WebElement playerName;

	@FindBy(id="com.fivemobile.thescore:id/team_name")
	private WebElement teamName;

	@FindBy(id="Navigate up")
	private WebElement navigateBackButton;


	public void setActivity(){
		//screen to home page
		Activity activity = new Activity("com.fivemobile.thescore", "com.fivemobile.thescore.ui.MainActivity");
		driver.startActivity(activity);
	}
	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickButton(WebElement element) {
		waitForElementToBeVisible(element);
		element.click();
	}
	
	public void sendText(WebElement element, String text) {
		waitForElementToBeVisible(element);
		element.sendKeys(text);
	}
	
	public void clickActionButton() {
		clickButton(actionButton);
	}
	
	public void clickAllowLocationButton() {
		clickButton(allowLocationButton);
	}
	
	public void clickOneTimeLocationButton() {
		clickButton(allowOneTimeButton);
	}
	
	public void clickSearchBarPlaceholder() {
		clickButton(searchPlaceholder);
	}
	
	public void searchChoice(String text) {
		sendText(searchInputBox, text);
	}
	
	public void selectChoice(String Name) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@resource-id,'com.fivemobile.thescore:id/txt_name') and contains(@text,'"+Name+"')]"))));
		searchChoice = driver.findElement(By.xpath("//*[contains(@resource-id,'com.fivemobile.thescore:id/txt_name') and contains(@text,'"+Name+"')]"));
		searchChoice.click();
	}
	
	public void clickContinueButton() {
		waitForElementToBeVisible(continueButton);
		continueButton.click();
	}
	
	public void clickDismissalModalButton() {
		waitForElementToBeVisible(dismissModalButton);
		dismissModalButton.click();
	}
	
	public void clickSearchBarView() {
		waitForElementToBeVisible(searchBarView);
		searchBarView.click();
	}

	public WebElement getSubTab(String tabName){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@content-desc, '"+tabName+"')]"))));
		subTab = driver.findElement(By.xpath("//*[contains(@content-desc, '"+tabName+"')]"));
		return subTab;
	}

	public void selectSubTab(String tabName) {
		getSubTab(tabName).click();
	}
	
	public String getPlayerName() {
		waitForElementToBeVisible(playerName);
		return playerName.getText();
	}

	public String getTeamName() {
		waitForElementToBeVisible(teamName);
		return teamName.getText();
	}

	public void getStarted(){
		try {
			//Click get started button
			clickActionButton();

			//Clicks continue button
			clickActionButton();
		} catch(Exception e) {
			// do nothing
		}
	}
	public void allowLocation() {
		try {
			// Clicks allow location button
			clickAllowLocationButton();

			//Clicks allow only once button
			clickOneTimeLocationButton();
		} catch (Exception e) {
			// do nothing
		}
	}
	public void selectYourFavoriteTeam(String teamName) {
		try{
			clickSearchBarPlaceholder();

			//Search the team
			searchChoice(teamName);

			//Mark the team as favorite
			selectChoice(teamName);

			//Select the continue button
			clickContinueButton();

			//Select the done button
			clickContinueButton();

			//Select the close button to close the download app modal
			clickDismissalModalButton();
		} catch (Exception e) {
			// do nothing
		}
	}

	public String clickNavigateBackButton() {
		waitForElementToBeVisible(navigateBackButton);
		return navigateBackButton.getText();
	}

	public String getSubTabText(String tabName){
		return getSubTab(tabName).getText();
	}
	
	
	
}
