package repository.user;

import dto.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByUserNameOrNameOrProfileOrCreatedOn(
            String userName,
            String name,
            String profile,
            String createdOn
    );
    Page<User> findAll(Pageable pageable);
}

