package net.petrikainulainen.spring.restful.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.support.BindingAwareModelMap;

import static junit.framework.Assert.assertEquals;

/**
 * @author Petri Kainulainen
 */
public class ServiceControllerTest {

    private final static String SERVICE_NAME = "Consulting";
    
    private ServiceController controller;

    @Before
    public void setUp() {
        controller = new ServiceController();
    }
    
    @Test
    public void showPage() {
        BindingAwareModelMap model = new BindingAwareModelMap();
        String pageView = controller.showPage(SERVICE_NAME, model);
        assertEquals(ServiceController.SERVICE_VIEW, pageView);
    }
    
}
