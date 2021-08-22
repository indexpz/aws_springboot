package pl.indexpz.aws_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.indexpz.aws_springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
