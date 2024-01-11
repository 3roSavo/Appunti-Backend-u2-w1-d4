package savogineros.AppuntiBackendu2w1d4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import savogineros.AppuntiBackendu2w1d4.dao.UsersService;
import savogineros.AppuntiBackendu2w1d4.entities.User;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

@Component
public class UsersRunner implements CommandLineRunner {
    @Autowired
    private UsersService usersService;
    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(Locale.ITALIAN);
        Random rndm = new Random();

        User user = new User(faker.lordOfTheRings().character(), faker.name().lastName(), faker.internet().emailAddress(), rndm.nextInt(1,101));
        // --------SAVE-----------
        System.out.println("--------SAVE-----------");

        //usersService.save(user);

        // -------FIND BY ID------
        System.out.println("--------FIND BY ID-----------");

        try { // metto un try catch cosicchè nel caso provassi degli id che non ci sono non crasha tutta l'app
            System.out.println(usersService.findById(202));
            System.out.println(usersService.findById(152));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        // --------- FIND ALL-------------
        System.out.println("--------FIND ALL-----------");

        usersService.findAll().forEach(user1 -> System.out.println(user1));




    }
}
