package net.petrikainulainen.spring.restful.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.support.BindingAwareModelMap;

import static junit.framework.Assert.assertEquals;

/**
 * @author Petri Kainulainen
 */
public class PhoneControllerTest {

    private static final String PHONE_MODEL = "Nokia N9";
    
    private PhoneController controller;
    
    @Before
    public void setUp() {
        controller = new PhoneController();
    }
    
    @Test
    public void showPage() {
        BindingAwareModelMap model  = new BindingAwareModelMap();
        String pageView = controller.showPage(PHONE_MODEL, model);
        assertEquals(PhoneController.PHONE_VIEW, pageView);
    }

}
