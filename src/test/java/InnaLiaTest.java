import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class InnaLiaTest {

    //TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню SearchParis
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2Tag_WhenSearchingCityCountry() throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCity = driver.findElement (
                By.xpath("//div[@id='weather-widget']//input[@placeholder = 'Search city']"));
        searchCity.click();
        Thread.sleep(1000);
        searchCity.sendKeys(cityName);
        Thread.sleep(1000);

        WebElement submitButtonSearch = driver.findElement(
                By.xpath("//button[@type='submit']"));
        submitButtonSearch.click();

        Thread.sleep(1000);
        WebElement parisFrDropdownChoice = driver.findElement(
                By.xpath("//ul[@class='search-dropdown-menu']/li/span[text()='Paris, FR ']"));
        parisFrDropdownChoice.click();

        Thread.sleep(1000);
        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id='weather-widget']//h2"));
        Thread.sleep(1000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

       // driver.get(url);

        //Thread.sleep(5000);

        driver.quit();
    }
    //TC_11_01
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню Guide
    //3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой страницы
    // OpenWeatherMap API guide - OpenWeatherMap
    @Test
    public void testGuideUrlTitleOfHeader() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultUrl = "https://openweathermap.org/guide";
        String expectedResultTitle = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement menuGuide = driver.findElement(
                By.xpath("//div[@id='desktop-menu']/ul/li/a[@href ='/guide']"));
        menuGuide.click();

        String actualResultUrl = driver.getCurrentUrl();
        String actualResultTitle = driver.getTitle();

        Assert.assertEquals(actualResultUrl, expectedResultUrl);
        Assert.assertEquals(actualResultTitle, expectedResultTitle);

        driver.quit();
    }
    //TC_11_02
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //3.  Подтвердить, что температура для города показана в Фарингейтах
    @Test public void testFMeasure() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultFahrenheit = "°F";

        driver.get(url);
        Thread.sleep(5000);

        WebElement measureImperialF = driver.findElement(
                By.xpath("//div[@id='weather-widget']//div[text()='Imperial: °F, mph']"));
        measureImperialF.click();

        WebElement measureFElement = driver.findElement(
                By.xpath("//div[@id='weather-widget']//span[@class='heading']"));
        String measureFElement1 = measureFElement.getText();

        String actualResult = measureFElement1.substring(measureFElement1.length() - 2);

        Assert.assertEquals(actualResult, expectedResultFahrenheit);

        driver.quit();
    }
    //TC_11_03
    //1.  Открыть базовую ссылку
    //2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
    //We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can
    // allow all cookies or manage them individually.”
    //3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”
    @Test
    public void testBottomPanelAndTwoButtonsOnIt() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultPanelText = "We use cookies which are essential for the site to work. We also use " +
                "non-essential cookies to help us improve our services. Any data collected is anonymised. You can " +
                "allow all cookies or manage them individually.";
        String expectedResultAllowAllButton = "Allow all";
        String expectedResultManageCookiesButton = "Manage cookies";

        driver.get(url);
        Thread.sleep(5000);

        WebElement bottomPanel = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//p[@class='stick-footer-panel__description']"));
        bottomPanel.getText();

        WebElement buttonAllowAll = driver.findElement(By.xpath("//button[text()='Allow all']"));
        buttonAllowAll.getText();

        WebElement buttonManageCookies = driver.findElement(By.xpath("//a[@class='stick-footer-panel__link']"));
        buttonManageCookies.getText();

        String actualResultBottomPanel = bottomPanel.getText();
        String actualResultButtonAllowAll = buttonAllowAll.getText();
        String actualResultButtonManageCookies= buttonManageCookies.getText();

        Assert.assertEquals(actualResultBottomPanel, expectedResultPanelText);
        Assert.assertEquals(actualResultButtonAllowAll, expectedResultAllowAllButton);
        Assert.assertEquals(actualResultButtonManageCookies, expectedResultManageCookiesButton);

        driver.quit();
    }

      //TC_11_04
      //1.  Открыть базовую ссылку
      //2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
    @Test
    public void testSubMenuNamesUnderSupportMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultFirstSubmenuName = "FAQ";
        String expectedResultSecondSubmenuName = "How to start";
        String expectedResultThirdSubmenuName = "Ask a question";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement menuSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        menuSupport.click();

        WebElement submenuFirstSubmenuName = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href ='/faq']"));
        submenuFirstSubmenuName.getText();

        WebElement subMenuSecondSubmenuName = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href ='/appid']"));
        subMenuSecondSubmenuName.getText();

        WebElement subMenuThirdSubmenuName = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[text()='Ask a question']"));
        subMenuThirdSubmenuName.getText();

        String actualResultFirstSubmenu = submenuFirstSubmenuName.getText();
        String actualResultSecondSubmenu = subMenuSecondSubmenuName.getText();
        String actualResultThirdSubmenu = subMenuThirdSubmenuName.getText();


        Assert.assertEquals(actualResultFirstSubmenu, expectedResultFirstSubmenuName);
        Assert.assertEquals(actualResultSecondSubmenu, expectedResultSecondSubmenuName);
        Assert.assertEquals(actualResultThirdSubmenu, expectedResultThirdSubmenuName);

        driver.quit();
    }
    //TC_11_05
    //1. Открыть базовую ссылку
    //2. Нажать пункт меню Support → Ask a question
    //3. Заполнить поля Email, Subject, Message
    //4. Не подтвердив CAPTCHA, нажать кнопку Submit
    //5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
    @Test
    public void testErrorCaptcha() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        //String url1 = "https://home.openweathermap.org/questions";
        String message = "Test";
        String email = "test@test.com";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement menuSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        menuSupport.click();
        Thread.sleep(3000);

        WebElement subMenuSupportAskQuestion = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[text()='Ask a question']"));
        subMenuSupportAskQuestion.click();
        Thread.sleep(5000);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement emailAddToField = driver.findElement(
                By.xpath("//input[@id='question_form_email']"));
        emailAddToField.sendKeys(email);
        Thread.sleep(5000);

        WebElement subjectField = driver.findElement(By.xpath("//select[@id='question_form_subject']"));
        subjectField .click();
        Thread.sleep(5000);

        WebElement subjectSelectForm = driver.findElement(
                By.xpath("//select[@id='question_form_subject']/option[@value='Sales']"));
        subjectSelectForm.click();
        Thread.sleep(5000);

        WebElement messageField = driver.findElement(By.xpath("//textarea[@id='question_form_message']"));
        Thread.sleep(5000);
        messageField.sendKeys(message);
        Thread.sleep(5000);

        WebElement buttonSubmitAskQuestionsSubmenu = driver.findElement(
                By.xpath("//div[@class='col-sm-8']/input[@type='submit']"));
        buttonSubmitAskQuestionsSubmenu.click();
        Thread.sleep(5000);

        WebElement reCaptchaErrorMessage = driver.findElement(
                By.xpath("//div[@class='col-sm-8']/div/div[@class='help-block']"));
        reCaptchaErrorMessage.getText();
        Thread.sleep(5000);

        String actualResultErrorMessageReCaptcha = reCaptchaErrorMessage.getText();

        Assert.assertEquals(actualResultErrorMessageReCaptcha, expectedResult);

        driver.quit();
    }
    //TC_11_06
    //1.  Открыть базовую ссылку
    //2.  Нажать пункт меню Support → Ask a question
    //3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
    //4. Оставить пустым поле Email
    //5. Заполнить поля  Subject, Message
    //6. Подтвердить CAPTCHA
    //7. Нажать кнопку Submit
    //8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”
    @Test
    public void testEmptyEmailField() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String message = "Test";
        String expectedResult = "can't be blank";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement menuSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        menuSupport.click();
        Thread.sleep(3000);

        WebElement subMenuSupportAskQuestion = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li/a[text()='Ask a question']"));
        subMenuSupportAskQuestion.click();
        Thread.sleep(5000);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement subjectField = driver.findElement(By.xpath("//select[@id='question_form_subject']"));
        subjectField .click();
        Thread.sleep(5000);

        WebElement subjectSelectForm = driver.findElement(
                By.xpath("//select[@id='question_form_subject']/option[@value='Sales']"));
        subjectSelectForm.click();
        Thread.sleep(5000);

        WebElement messageField = driver.findElement(By.xpath("//textarea[@id='question_form_message']"));
        messageField.sendKeys(message);
        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title=reCAPTCHA]")));

        WebElement captchaCheckbox = driver.findElement(
                By.xpath("//span[@id='recaptcha-anchor']"));
        captchaCheckbox.click();
        Thread.sleep(10000);

        WebElement buttonSubmitAskQuestionsSubmenu = driver.findElement(
                By.xpath("//input[@data-disable-with='Create Question form']"));
        buttonSubmitAskQuestionsSubmenu.click();
        Thread.sleep(10000);

        WebElement errorMessageUnderEmailField = driver.findElement(By.xpath("//span[@class='help-block']"));
        Thread.sleep(3000);
        errorMessageUnderEmailField.getText();

        String actualResultErrorMessage = errorMessageUnderEmailField.getText();

        Assert.assertEquals(actualResultErrorMessage, expectedResult);

        driver.quit();
    }




}
