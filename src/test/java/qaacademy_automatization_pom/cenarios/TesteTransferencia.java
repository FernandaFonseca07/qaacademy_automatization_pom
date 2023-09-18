package qaacademy_automatization_pom.cenarios;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qaacademy_automatization_pom.pages.HomePage;
import qaacademy_automatization_pom.pages.LoginPage;
import qaacademy_automatization_pom.pages.TransferenciaPage;

public class TesteTransferencia {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    TransferenciaPage transferenciaPage;

    String email = "teste@gmail.com";
    String senha = "teste";

    @Before
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        transferenciaPage = new TransferenciaPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");
        usuarioCadastro();
        usuarioLogin();
    }

    @Test
    public void testePrimeiraTransferencia () throws InterruptedException{
        String msgValidacao = "Conta inválida ou inexistente";
        transferenciaPage.clicarTransferencia();
        transferenciaPage.digitarNumeroConta("486");
        transferenciaPage.digitarDigitoConta("5");
        transferenciaPage.valorTransferencia("50");
        transferenciaPage.digitarDescricao("Transferência teste");
        transferenciaPage.transferirAgora();
        mensagemConfirmacao(msgValidacao);
        transferenciaPage.fecharBoxTransferencia();
    }

    @After
    public void finalizar() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public void mensagemConfirmacao(String mensagemNaTela) {
        Assert.assertTrue(driver.getPageSource().contains(mensagemNaTela));
    }

    public void confirmacaoURL(String pagina) {
        Assert.assertTrue(driver.getCurrentUrl().contains(pagina));
    }

    public void usuarioCadastro() throws InterruptedException {
        homePage.clicarRegistrar();
        homePage.preencherEmail(email);
        homePage.preencherNome("Fe Fonseca");
        homePage.preencherSenha(senha);
        homePage.preencherConfirmacaoSenha(senha);
        homePage.clicarCriarComSaldo();
        homePage.clicarCadastrar();
        mensagemConfirmacao("foi criada com sucesso");
        homePage.fecharCadastroComSucesso();
    }

    public void usuarioLogin() throws InterruptedException {
        String msgValidacao = "bem vindo ao BugBank :)";
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
        loginPage.clicarAcessar();
        Thread.sleep(2000);
        mensagemConfirmacao(msgValidacao);
        confirmacaoURL("/home");
    }
}