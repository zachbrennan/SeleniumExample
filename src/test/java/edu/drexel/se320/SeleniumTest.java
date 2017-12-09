// Based on the example code at http://www.seleniumhq.org/docs/03_webdriver.jsp
package edu.drexel.se320;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.NoSuchElementException;
import java.util.List;
import org.junit.Test;

public class SeleniumTest {

    protected final String uiPath = "file:///home/zach/Documents/se320/homework5/web/index.html";

    @Test
    public void testOneItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */
            WebElement li = driver.findElement(By.id("item1"));
            // We use startsWith because getText includes the text of the Delete button
            assertTrue("Checking correct text for added element",
                       li.getText().startsWith("Something to do"));
        } finally {
            driver.quit();
        }
    }


        @Test
        public void testRemoveItem() {
            WebDriver driver = new FirefoxDriver();
            try {
                driver.get(uiPath);
                // Find the + to click to display the form to add a todo
                // Looking up by the id, not the name attribute
                WebElement elt = driver.findElement(By.id("controls1plus"));

                // Click on the [+]
                elt.click();

                // Find the form field
                WebElement input = driver.findElement(By.id("itemtoadd"));

                // Make up a todo
                input.sendKeys("Something to do");

                // Find and click the "Add to list" button
                WebElement addButton = driver.findElement(By.id("addbutton"));
                addButton.click();

                // Find and click the "Delete" button
                WebElement deleteButton = driver.findElement(By.id("button1"));
                deleteButton.click();

                List<WebElement> li = driver.findElements(By.id("item1"));

                assertEquals(li.size(), 0);

            } finally {
                driver.quit();
            }
      }

      @Test
      public void testRemoveFirstItem() {
          WebDriver driver = new FirefoxDriver();
          try {
              driver.get(uiPath);
              // Find the + to click to display the form to add a todo
              // Looking up by the id, not the name attribute
              WebElement elt = driver.findElement(By.id("controls1plus"));

              // Click on the [+]
              elt.click();

              // Find the form field
              WebElement input = driver.findElement(By.id("itemtoadd"));

              // Make up a todo
              input.sendKeys("Something to do");

              // Find and click the "Add to list" button
              WebElement addButton = driver.findElement(By.id("addbutton"));
              addButton.click();

              input.sendKeys("A second TODO");
              addButton.click();

              // Find and click the "Delete" button
              WebElement deleteButton = driver.findElement(By.id("button1"));
              deleteButton.click();

              WebElement li = driver.findElement(By.id("item2"));

              //change to clear this thing.
              assertTrue(li.getText().startsWith("Something to doA second TODO"));

          } finally {
              driver.quit();
          }
    }

    @Test
    public void testRemoveAllItems() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            input.sendKeys("A second TODO");
            addButton.click();

            // Find and click the "Delete" button
            WebElement deleteButton = driver.findElement(By.id("button1"));
            deleteButton.click();

            WebElement delete2Button = driver.findElement(By.id("button2"));
            delete2Button.click();

            List<WebElement> li = driver.findElements(By.id("item1"));

            assertEquals(li.size(), 0);

        } finally {
            driver.quit();
        }
  }

  @Test
  public void testPlusMinusPlus() {
      WebDriver driver = new FirefoxDriver();
      try {
          driver.get(uiPath);
          // Find the + to click to display the form to add a todo
          // Looking up by the id, not the name attribute
          WebElement elt = driver.findElement(By.id("controls1plus"));

          // Click on the [+]
          elt.click();

          WebElement elm = driver.findElement(By.id("controls1minus"));

          elm.click();
          elt.click();

          // Find the form field
          WebElement input = driver.findElement(By.id("itemtoadd"));

          // Make up a todo
          input.sendKeys("Something to do");

          // Find and click the "Add to list" button
          WebElement addButton = driver.findElement(By.id("addbutton"));
          addButton.click();

          WebElement li = driver.findElement(By.id("item1"));

          assertTrue(li.getText().startsWith("Something to do"));

      } finally {
          driver.quit();
      }
}

}
