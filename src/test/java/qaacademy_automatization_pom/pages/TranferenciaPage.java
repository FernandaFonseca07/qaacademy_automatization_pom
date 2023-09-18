package qaacademy_automatization_pom.pages;

import org.openqa.selenium.WebDriver;

public class TranferenciaPage {
    WebDriver driver;

    String TRANSFERENCIA = "//*[@id='btn-TRANSFERÊNCIA']";

    public TranferenciaPage (WebDriver driverConta){
        this.driver = driverConta;
    }


}
