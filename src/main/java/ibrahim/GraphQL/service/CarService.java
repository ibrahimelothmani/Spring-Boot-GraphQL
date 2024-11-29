package ibrahim.GraphQL.service;


import ibrahim.GraphQL.model.Car;
import ibrahim.GraphQL.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Integer id) {
        return carRepository.findById(id);
    }

    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }
}
