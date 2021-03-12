package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {

        ApplicationContext ctx= SpringApplication.run(SfgDiApplication.class, args);

        PetController petController=(PetController) ctx.getBean("petController");
        System.out.println("the best animal is");
        System.out.println(petController.whichPetIsTheBest());

        I18nController i18nController=(I18nController) ctx.getBean("i18nController") ;
        System.out.println(i18nController.sayGreeting());

        MyController myController=(MyController) ctx.getBean("myController");

        System.out.println("=============primary bean-==========");
        System.out.println(myController.sayGreeting());
        System.out.println("=========property=============");

        PropertyInjectionController propertyInjectionController=(PropertyInjectionController) ctx.getBean("propertyInjectionController");
        System.out.println(propertyInjectionController.getGreeting());

        SetterInjectedController setterInjectedController=(SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println("===========setter ===========");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("=================constructor=============");
        ConstructorInjectedController constructorInjectedController=(ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}
