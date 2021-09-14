package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    /*
    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }
    */
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Profile("ES")
    @Bean
    I18NSpanishService i18nService(){
        return new I18NSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"EN", "default"})
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }
}
