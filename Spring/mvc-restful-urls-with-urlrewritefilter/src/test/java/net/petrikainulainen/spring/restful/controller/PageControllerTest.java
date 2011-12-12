package net.petrikainulainen.spring.restful.controller;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Petri Kainulainen
 */
public class PageControllerTest {
    private PageController controller;
    
    @Before
    public void setUp() {
        controller = new PageController();
    }
    
    @Test
    public void showPage() {
        String pageView = controller.showPage();
        assertEquals(PageController.PAGE_VIEW, pageView);
    }

}
