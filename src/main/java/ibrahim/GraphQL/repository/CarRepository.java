package ibrahim.GraphQL.repository;

import ibrahim.GraphQL.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface CarRepository extends JpaRepository<Car, Integer>, QueryByExampleExecutor<Car> {
    List<Car> findByName(String name);
}
