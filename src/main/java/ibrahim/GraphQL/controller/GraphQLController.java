package ibrahim.GraphQL.controller;

import ibrahim.GraphQL.model.TheUser;
import ibrahim.GraphQL.model.Car;
import ibrahim.GraphQL.service.UserService;
import ibrahim.GraphQL.service.CarService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/graphiql")
public class GraphQLController {

    private final UserService userService;
    private final CarService carService;

    public GraphQLController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    // Query to fetch all users with optional filter
    @QueryMapping
    public List<TheUser> users(@Argument String filter) {
        return userService.getAllUsers(); // You can implement filtering based on the input
    }

    // Query to fetch a single user by ID
    @QueryMapping
    public TheUser theUser(@Argument Integer id) {
        return userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Query to fetch all cars
    @QueryMapping
    public List<Car> cars() {
        return carService.getAllCars();
    }

    // Query to fetch a single car by ID
    @QueryMapping
    public Car car(@Argument Integer id) {
        return carService.getCarById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    // Mutation to create a new user
    @MutationMapping
    public TheUser createUser(@Argument TheUser input) {
        return userService.saveUser(input);
    }

    // Mutation to update an existing user
    @MutationMapping
    public TheUser updateUser(@Argument Integer id, @Argument TheUser input) {
        if (!userService.getUserById(id).isPresent()) {
            throw new RuntimeException("User not found");
        }
        input.setId(id);  // Set the ID to ensure the correct user is updated
        return userService.saveUser(input);
    }

    // Mutation to create a new car
    @MutationMapping
    public Car createCar(@Argument Car input) {
        return carService.saveCar(input);
    }

    // Mutation to update an existing car
    @MutationMapping
    public Car updateCar(@Argument Integer id, @Argument Car input) {
        if (!carService.getCarById(id).isPresent()) {
            throw new RuntimeException("Car not found");
        }
        input.setId(id);  // Set the ID to ensure the correct car is updated
        return carService.saveCar(input);
    }
}
