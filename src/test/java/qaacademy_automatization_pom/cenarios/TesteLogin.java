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

public class TesteLogin {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginpage;

    String email = "teste@gmail.com";
    String senha = "teste";

    @Before
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginpage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");
        cadastroUsuario();
    }

    @Test
    public void testeLogin() throws InterruptedException {
        String msgValidacao = "bem vindo ao BugBank :)";
        loginpage.preencherEmail(email);
        loginpage.preencherSenha(senha);
        loginpage.clicarAcessar();
        Thread.sleep(2000);
        mensagemConfirmacao(msgValidacao);
        confirmacaoURL("/home");
    }

    @Test
    public void testeLoginErrado() throws InterruptedException {
        String msgDeErro = "Usuário ou senha inválido.";
        loginpage.preencherEmail(email);
        loginpage.preencherSenha("erro");
        loginpage.clicarAcessar();
        mensagemConfirmacao(msgDeErro);
        loginpage.fecharMensagemErro();    
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

    public void cadastroUsuario() throws InterruptedException {
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

}
