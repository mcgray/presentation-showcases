package ua.com.mcgray;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ua.com.mcgray.pageobjects.JugLvivSbeWorkshopAnnouncePage;

/**
 * Created with IntelliJ IDEA.
 * User: orezchykov
 * Date: 06.09.12
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */
@RunWith(ConcordionRunner.class)
public class JugLvivSbeWorkshopAnnounceTest {

     private JugLvivSbeWorkshopAnnouncePage announcePage;

    @Before
    public void setUp() {
        announcePage = PageFactory.initElements(new ChromeDriver(), JugLvivSbeWorkshopAnnouncePage.class);
        announcePage.open();
    }

    public boolean postTitleContains(String titleText) {
        System.out.println(announcePage.getPostTitle());
        System.out.println(titleText);
        return announcePage.getPostTitle().equals(titleText);
    }

    public boolean presentInPostCommenters(String commenter) {
        return announcePage.getCommentAuthors().contains(commenter);
    }

    public boolean presentInComments(String text) {
        for (String commentText: announcePage.getCommentTexts()) {
            if (commentText.contains(text)) {
                return true;
            }
        }
        return false;
    }

    @After
    public void tearDown() {
        announcePage.close();
    }

}
