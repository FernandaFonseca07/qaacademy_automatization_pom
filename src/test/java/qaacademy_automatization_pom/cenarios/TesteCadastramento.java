package qaacademy_automatization_pom.cenarios;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qaacademy_automatization_pom.pages.HomePage;

public class TesteCadastramento {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testePositivoCadastro() throws InterruptedException {
        homePage.clicarRegistrar();
        homePage.preencherEmail("teste@gmail.com");
        homePage.preencherNome("Fe Fonseca");
        homePage.preencherSenha("teste");
        homePage.preencherConfirmacaoSenha("teste");
        homePage.clicarCriarComSaldo();
        homePage.clicarCadastrar();
        mensagemConfirmacao("foi criada com sucesso");
        homePage.fecharCadastroComSucesso();
    }

    @Test
    public void testeCadastroVazio (){
        homePage.clicarRegistrar();
        homePage.clicarCadastrar();
        mensagemConfirmacao("É campo obrigatório");
    }


    @After
    public void finalizar () throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }


    public void mensagemConfirmacao (String mensagemNaTela){
                Assert.assertTrue(driver.getPageSource().contains(mensagemNaTela));
    }
}

