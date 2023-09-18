package qaacademy_automatization_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    String REGISTRAR = "//button[contains(text(),'Registrar')]";
    String EMAIL = "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/input[1]";
    String NOME = "//*[@id='__next']/div/div[2]/div/div[2]/form/div[3]/input";
    String SENHA = "//*[@id='__next']/div/div[2]/div/div[2]/form/div[4]/div/input";
    String CONFIRMARSENHA = "//*[@id='__next']/div/div[2]/div/div[2]/form/div[5]/div/input";
    String CRIAR_SALDO = "//*[@id='__next']/div/div[2]/div/div[2]/form/div[6]/label/span";
    String CADASTRAR = "//button[contains(text(),'Cadastrar')]";
    String FECHAR = "//*[@id='btnCloseModal']";

    public HomePage (WebDriver driverParametro){
        this.driver = driverParametro;
    }

    public void clicarRegistrar() {
        driver.findElement(By.xpath(REGISTRAR)).click();
    }

    public void preencherEmail(String email) {
        driver.findElement(By.xpath(EMAIL)).sendKeys(email);
    }

    public void preencherNome(String nome) {
        driver.findElement(By.xpath(NOME)).sendKeys(nome);
    }

    public void preencherSenha(String senha) {
        driver.findElement(By.xpath(SENHA)).sendKeys(senha);
    }

    public void preencherConfirmacaoSenha(String confirmacaoSenha) {
        driver.findElement(By.xpath(CONFIRMARSENHA)).sendKeys(confirmacaoSenha);
    }

    public void clicarCriarComSaldo() {
        driver.findElement(By.xpath(CRIAR_SALDO)).click();
    }

    public void clicarCadastrar() {
        driver.findElement(By.xpath(CADASTRAR)).click();
    }

    public void fecharCadastroComSucesso () throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath(FECHAR)).click();
    }
}
