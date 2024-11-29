package ibrahim.GraphQL.repository;

import ibrahim.GraphQL.model.TheUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface UserRepository extends JpaRepository<TheUser, Integer>, QueryByExampleExecutor<TheUser> {

}
