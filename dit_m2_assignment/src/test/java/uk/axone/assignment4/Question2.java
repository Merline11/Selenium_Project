package uk.axone.assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Question2 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("http://uitest.automationtester.uk/drag-and-drop-demo.html");
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        Thread.sleep(2000);
    }

    @Test
    public void testHandleDragAndDrop() throws InterruptedException {
        //WebElement drag = driver.findElement(By.xpath("//span[contains(text(),'Draggable 1')]"));
        WebElement drag = driver.findElement(By.xpath("//div[@id='todrag']/span[1]"));
        WebElement drop = driver.findElement(By.id("mydropzone"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        Thread.sleep(2000);

        //WebElement to = driver.findElement(By.xpath("//h3[contains(text(),'Dropped Items List')]"));
        WebElement to = driver.findElement(By.xpath("//div[@id='droppedlist']/span[1]"));
/*        String textTo = to.getText();
        if(textTo.equals("Draggable 1")) {
            System.out.println("PASS: Draggable 1 item is dropped to target as expected");
        }else {
            System.out.println("FAIL: Draggable 1 item couldn't be dropped to target as expected");
        }*/

        Assert.assertEquals("Draggable 1",to.getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
