import com.codeborne.selenide.*;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class MyNewTest

{
    @Test
    public void FirstAutoTest() {

        //ტესტ მეთოდი 1 - დადებითი მნიშვნელობები

        open("https://ee.ge/");
        Configuration.browserSize = "1920x1080";

        $(byId("rcc-confirm-button")).click();
        $(byText("რეგისტრაცია")).click();


        $(byText("სწრაფი რეგისტრაცია")).shouldBe(visible);
        $(byId("firstName")).setValue("Peter").shouldNotBe(Condition.empty);
        $(byId("lastName")).setValue("Pan").shouldNotBe(Condition.empty);
        $(byId("email")).setValue("peterpan@peter.ge").shouldNotBe(Condition.empty);
        $(byId("password")).setValue("qwerty1").shouldNotBe(Condition.empty);
        $(byId("confirmPassword")).setValue("qwerty1").shouldNotBe(Condition.empty);
        $(byId("singup")).shouldBe(visible);
        sleep(500);
    }
    @Test
    public void SecondtAutoTest(){
        //ტესტ მეთოდი 2 - ნეგატიური მნიშვნელობები

        open("https://ee.ge/");
        Configuration.browserSize = "1920x1080";

        $(byId("rcc-confirm-button")).click();
        $(byText("რეგისტრაცია")).click();

        $(byText("სწრაფი რეგისტრაცია")).shouldBe(visible);
        $(byId("singup")).shouldBe(Condition.disabled);
        $(byId("firstName")).click();
        $(byId("lastName")).click();
        $(byId("email")).click();
        $(byId("password")).click();
        $(byId("confirmPassword")).click();
        $(byId("password")).click();

        $(byText("სახელი სავალდებულოა")).shouldBe(visible);
        $(byText("გვარი სავალდებულოა")).shouldBe(visible);
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(visible);
        $(byText("პაროლი სავალდებულოა.")).shouldBe(visible);
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(visible);
        sleep(5000);


        $(byId("email")).setValue("peterpan#peter.ge").shouldNotBe(Condition.empty);
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(visible);

        $(byId("password")).setValue("qwert").shouldNotBe(Condition.empty);
        $(byText("პაროლი სავალდებულოა.")).shouldBe(visible);

        $(byId("confirmPassword")).setValue("qwerty1").shouldNotBe(Condition.empty);
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(visible);

        sleep(5000);
    }
        @Test
        public void ThirdAutoTest() {
            //ტესტ მეთოდი 3

            open("https://ee.ge/");
            Configuration.browserSize = "1920x1080";

            $(byId("rcc-confirm-button")).click();


            $(byClassName("cart-count")).click();
            $(byText("კალათა ცარიელია")).shouldBe(visible);
            sleep(5000);

            $(byId("search_list")).setValue("lenovo");
            $(byClassName("fa-search")).click();
            sleep(5000);


            ElementsCollection collection = $$(byClassName("fa-shopping-cart"));
            int count = collection.size();
            for (int i = 0; i < count; i++) ;
            $(byClassName("fa-shopping-cart"), 0).click();
            sleep(5000);

            $(byClassName("cart-count")).click();
            $(byText("კალათა ცარიელია")).shouldNotBe(Condition.visible);
            sleep(5000);

            $(byText("წაშლა")).click();
            $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
            sleep(5000);
        }
            @Test
            public void FourthAutoTest(){


        //ტესტ მეთოდი 4

                open("https://ee.ge/");
                Configuration.browserSize = "1920x1080";

                $(byId("rcc-confirm-button")).click();


                $(byClassName("cart-count")).click();
                $(byText("კალათა ცარიელია")).shouldBe(visible);
                sleep(5000);

                $(byText("შენახული ნივთები")).click();
                $(byText("ვერ მოიძებნა")).shouldBe(visible);
                sleep(5000);

                $(byId("search_list")).setValue("lenovo");
                $(byClassName("fa-search")).click();
                sleep(5000);

                ElementsCollection collection = $$(byClassName("fa-shopping-cart"));
                int count = collection.size();
                for (int i = 0; i < count; i++) ;
                $(byClassName("fa-shopping-cart"), 0).click();
                sleep(5000);

                $(byClassName("cart-count")).click();
                $(byText("შენახვა")).click();
                sleep(5000);

                $(byText("შენახული ნივთები")).click();
                $(byText("ვერ მოიძებნა")).shouldNotBe(visible);
                sleep(5000);

                $(byClassName("cart-count")).click();
                $(byText("კალათა ცარიელია")).shouldBe(visible);
                sleep(5000);

                $(byText("შენახული ნივთები")).click();
                $(byClassName("fa-times")).click();
                $(byText("ვერ მოიძებნა")).shouldNotBe(visible);
                sleep(5000);
    }
}
