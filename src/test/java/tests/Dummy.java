package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class Dummy {

    @Test
    public void dummyTest() {
        System.out.println("This is a dummy test for Allure.");
    }
}
