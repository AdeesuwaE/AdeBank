package learn_spring_framework.ade.DataLayer.Repository;

import learn_spring_framework.ade.DataLayer.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Can use @Component but @Repository is more specific
//Does communication with the DB
public interface UserRepo extends JpaRepository<User, Long> {
    User getUserByEmail(String email);

}
