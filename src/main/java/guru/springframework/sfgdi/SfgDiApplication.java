package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx= SpringApplication.run(SfgDiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println(greeting);

		System.out.println("----------Property------------");
		PropertyInjectedController MyPropertyController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		greeting = MyPropertyController.getGreeting();
		System.out.println(greeting);

		System.out.println("----------Setter--------------");
		SetterInjectedController mySetterController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		greeting = mySetterController.getGreeting();
		System.out.println(greeting);

		System.out.println("----------Constructor---------");
		ConstructorInjectedController myConstructorController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		greeting = myConstructorController.getGreeting();
		System.out.println(greeting);

	}
}
