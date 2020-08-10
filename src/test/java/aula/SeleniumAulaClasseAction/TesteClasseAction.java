/*dragAndDrop(source, target): Clica e arrasta um elemento para outro elemento. Utiliza como parâmetro um elemento de origem e o elemento de destino.

dragAndDropBy(source, xOffset, yOffset): Clica e arrasta um elemento para outro elemento. Utiliza como parâmetro coordenadas X e Y.

moveToElement(toElement): Move o cursor para um elemento específico.

release(): Libera o clique do mouse (esquerdo).*/

package aula.SeleniumAulaClasseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TesteClasseAction {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// testaTeclado();
		// testaMouse();
		//testaContextClick();
		testaClickAndHold();

	}

	public static void testaTeclado() {
		String driverPath = "C:\\Users\\55519\\eclipse-workspace\\SeleniumAulaClasseAction\\drivers\\chrome\\084\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		// mapeando os elementos um por um (somente os envolvidos)

		//WebElement elementoEmail = driver.findElement(By.id("email"));
		//WebElement elementoPass = driver.findElement(By.id("pass"));
		WebElement elementoFirstName = driver.findElement(By.id("u_0_m"));
		WebElement elementoLastName = driver.findElement(By.id("u_0_o"));

		Actions act = new Actions(driver);

		// mantem pressionado a tecla shift
		act.keyDown(elementoFirstName, Keys.SHIFT).build().perform();
		act.sendKeys(elementoFirstName, "abner");

		// solta a tecla
		act.keyUp(elementoLastName, Keys.SHIFT).build().perform();
		act.sendKeys(elementoLastName, "antonio").build().perform();

	}

	public static void testaMouse() {
		String driverPath = "C:\\Users\\55519\\eclipse-workspace\\SeleniumAulaClasseAction\\drivers\\chrome\\084\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/login");
		Actions act = new Actions(driver);

		WebElement inputUsername = driver.findElement(By.cssSelector("input[name='username']"));
		WebElement inputSenha = driver.findElement(By.cssSelector("input[type='password']"));
		WebElement butEntrar = driver.findElement(By.cssSelector("button[type='submit']"));

		// act.sendKeys(inputUsername, "tomsmith111").build().perform();
		// act.sendKeys(inputSenha, "SuperSecretPassword!").build().perform();
		// click no elemento
		// act.click(butEntrar).build().perform();

		act.sendKeys(inputUsername, "tomsmith111").build().perform();
		act.doubleClick(inputUsername).build().perform();
		act.sendKeys(inputUsername, "tomsmith").build().perform();
		act.sendKeys(inputSenha, "SuperSecretPassword!").build().perform();
		act.click(butEntrar).build().perform();

	}

	public static void testaContextClick() throws InterruptedException {
		String driverPath = "C:\\Users\\55519\\eclipse-workspace\\SeleniumAulaClasseAction\\drivers\\chrome\\084\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		Actions act = new Actions(driver);

		WebElement botao = driver.findElement(By.cssSelector("span.context-menu-one"));

		// declaracao alternativa
		// act.contextClick(botao).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		// clicka com o botao direito do mouse
		act.contextClick(botao).build().perform();

		Thread.sleep(1500);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).build().perform();

	}

	public static void testaClickAndHold() throws InterruptedException {
		String driverPath = "C:\\Users\\55519\\eclipse-workspace\\SeleniumAulaClasseAction\\drivers\\chrome\\084\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/login");
		Actions act = new Actions(driver);

		WebElement inputUsername = driver.findElement(By.cssSelector("input[name='username']"));
		WebElement inputSenha = driver.findElement(By.cssSelector("input[type='password']"));
		WebElement butEntrar = driver.findElement(By.cssSelector("button[type='submit']"));

		act.sendKeys(inputUsername, "tomsmith").build().perform();
		Thread.sleep(1000);
		act.sendKeys(inputSenha, "SuperSecretPassword!").build().perform();
		Thread.sleep(1000);
		act.clickAndHold(butEntrar).build().perform();

	}

}
