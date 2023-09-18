package qaacademy_automatization_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferenciaPage {
    WebDriver driver;

    String TRANSFERENCIA = "//*[@id='btn-TRANSFERÊNCIA']";
    String NUMEROCONTA = "//*[@placeholder='Informe o número da conta']";
    String DIGITOCONTA = "//*[@placeholder='Informe o dígito da conta']";
    String VALORTRANSFERENCIA = "//*[@placeholder='Informe o valor da transferência']";
    String DESCRICAO = "//*[@placeholder='Informe uma descrição']";
    String TRANFERIR = "//button[contains(text(),'Transferir agora')]";
    String FECHARBOXTRANSFERENCIA = "//a[@id='btnCloseModal']";

    public TransferenciaPage (WebDriver driverConta){
        this.driver = driverConta;
    }

    public void clicarTransferencia(){
        driver.findElement(By.xpath(TRANSFERENCIA)).click();
    }

    public void digitarNumeroConta (String numeroConta){
        driver.findElement(By.xpath(NUMEROCONTA)).sendKeys(numeroConta);
    }

    public void digitarDigitoConta (String digitoConta){
        driver.findElement(By.xpath(DIGITOCONTA)).sendKeys(digitoConta);
    }

    public void valorTransferencia (String valorDaTransferencia){
        driver.findElement(By.xpath(VALORTRANSFERENCIA)).sendKeys(valorDaTransferencia);
    }

    public void digitarDescricao (String descricao){
        driver.findElement(By.xpath(DESCRICAO)).sendKeys(descricao);
    }

    public void transferirAgora () throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath(TRANFERIR)).click();
    }

    public void fecharBoxTransferencia (){
        driver.findElement(By.xpath(FECHARBOXTRANSFERENCIA)).click();
    }


}
