package learn_spring_framework.ade.DataLayer.Repository;

import learn_spring_framework.ade.DataLayer.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User getUserByEmail(String email);

}
