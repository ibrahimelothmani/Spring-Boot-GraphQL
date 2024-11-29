package ibrahim.GraphQL;

import ibrahim.GraphQL.model.Car;
import ibrahim.GraphQL.model.TheUser;
import ibrahim.GraphQL.service.CarService;
import ibrahim.GraphQL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    /**
     * @param args incoming main method arguments
     * @throws Exception
     */

    private final UserService userService;
    private final CarService carService;
    @Autowired
    public DataInitializer(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    @Override
    public void run(String... args) {
        TheUser theUser1 = new TheUser();
        theUser1.setName("ibrahim1");
        theUser1.setEmail("test@example.com"); // Valid
        theUser1.setPassword("2025"); // Valid
        theUser1.setPublishedYear(2000); // Valid

        TheUser theUser2 = new TheUser();
        theUser2.setName("ibrahim2");
        theUser2.setEmail("test@example.com"); // Valid
        theUser2.setPassword("2025"); // Valid
        theUser2.setPublishedYear(2000); // Valid

        theUser1 = userService.saveUser(theUser1);
        theUser2 = userService.saveUser(theUser2);

        Car car1 = new Car();
        car1.setName("Old");
        car1.setModel("BMW");
        car1.setOwner(theUser1);

        Car car2 = new Car();
        car2.setName("New");
        car2.setModel("Ford Mustang");
        car2.setOwner(theUser2);

        carService.saveCar(car1);
        carService.saveCar(car2);
    }

}
