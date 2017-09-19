package componentgroups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.framework.selenium.CraftDriver;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class SamplePage extends ReusableLibrary {

	private CraftDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	public WebElement login;
	
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='Login']")
	public WebElement submit;
	
	
	public SamplePage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
		this.driver = scriptHelper.getcraftDriver();
		PageFactory.initElements(scriptHelper.getcraftDriver().getWebDriver(), this);
	}
	
	public void logintoSFDC()
	{
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		login.sendKeys("arnabroy");
		Actions action = new Actions(driver.getWebDriver());
		action.sendKeys(password, "password").build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
