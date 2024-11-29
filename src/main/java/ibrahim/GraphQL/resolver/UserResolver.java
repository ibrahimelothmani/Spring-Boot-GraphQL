package ibrahim.GraphQL.resolver;

import ibrahim.GraphQL.model.Car;
import ibrahim.GraphQL.model.TheUser;
import ibrahim.GraphQL.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResolver {

    private final UserRepository userRepository;

    public UserResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<TheUser> users() {
        return userRepository.findAll();
    }

    @QueryMapping
    public TheUser userById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    // Optional resolver to prevent recursion while returning the `cars` data in User object
    @QueryMapping
    public List<Car> cars(TheUser user) {
        return user.getCars();  // Return cars only if explicitly requested, otherwise omit this field
    }
}
