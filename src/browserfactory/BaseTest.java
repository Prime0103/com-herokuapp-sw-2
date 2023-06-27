package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    public WebDriver driver;

        public void openBrowser(String baseurl) {
            //open the browser
            driver = new ChromeDriver();
            // Launch url
            driver.get(baseurl);
            // Maximise Window
            driver.manage().window().maximize();
            // implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        }

        public void closeBrowser() {
            //closing the browser
            driver.quit();

        }
    }

