package ibrahim.GraphQL.resolver;

import ibrahim.GraphQL.model.Car;
import ibrahim.GraphQL.model.TheUser;
import ibrahim.GraphQL.repository.CarRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarResolver {

    private final CarRepository carRepository;

    public CarResolver(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @QueryMapping
    public List<Car> cars() {
        return carRepository.findAll();
    }

    @QueryMapping
    public Car carById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    // Optionally add a resolver for the `owner` of the car if needed,
    // but avoid returning the entire `User` object with its `cars` field.
    @QueryMapping
    public TheUser owner(Car car) {
        return car.getOwner(); // Do not include the `cars` field here to avoid recursion
    }
}
