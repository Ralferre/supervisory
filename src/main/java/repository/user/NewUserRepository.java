package repository.user;

import dto.model.user.NewUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewUserRepository extends JpaRepository<NewUser, Integer> {
    Page<NewUser> findAll(Pageable pageable);
    Page<NewUser> findByUserNameOrNameOrEmailOrCreatedOn(
            String userName,
            String name,
            String email,
            String createdOn
    );
}
