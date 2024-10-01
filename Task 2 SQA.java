import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MindShift_Internship {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\chromedriver.exe");  
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  
    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws IOException {
        // Load data from CSV file
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("Desktop\\testdata.csv")); 
        Object[][] data = new Object[parser.getRecords().size()][2];
        int index = 0;
        for (CSVRecord record : parser) {
            data[index][0] = record.get("username");
            data[index][1] = record.get("password");
            index++;
        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        // Locate username field and input value
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Admin);
        // Locate password field and input value
        driver.findElement(By.cssSelector("#password")).sendKeys(admin123);
        // Click the login button
        driver.findElement(By.id("loginBtn")).click();

        // Verification (Modify as per actual behavior)
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";  
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login Test Failed: User not redirected to dashboard.");
        
        // Navigate back to login page for next iteration
        driver.navigate().back();
    }

    @AfterClass
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
