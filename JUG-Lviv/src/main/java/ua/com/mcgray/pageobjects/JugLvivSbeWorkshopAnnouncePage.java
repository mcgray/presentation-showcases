package ua.com.mcgray.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: orezchykov
 * Date: 06.09.12
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */

public class JugLvivSbeWorkshopAnnouncePage {

    public static final String POST_URL = "http://jug-lviv.blogspot.com/2012/08/workshop-spring-by-example.html";

    private final WebDriver webDriver;

    //@CacheLookup
    @FindBy(xpath = "//h3[@class='post-title entry-title']")
    private WebElement postTitle;



    public JugLvivSbeWorkshopAnnouncePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void open() {
        webDriver.get(POST_URL);
    }

    public String getPostTitle() {
         return postTitle.getText().trim();
    }

    public List<String> getCommentAuthors() {
        List<String> result = new ArrayList<String>();
        List<WebElement> commentAuthors = webDriver.findElements(By.cssSelector(".comment .user a"));
        for (WebElement commentAuthor : commentAuthors) {
            result.add(commentAuthor.getText());
        }

        return result;
    }

    public List<String> getCommentTexts() {
        List<String> result = new ArrayList<String>();
        List<WebElement> commentTexts = webDriver.findElements(By.cssSelector(".comment .comment-content"));
        for (WebElement commentText : commentTexts) {
            result.add(commentText.getText());
        }

        return result;
    }


    public void close() {
        webDriver.close();
    }


}
