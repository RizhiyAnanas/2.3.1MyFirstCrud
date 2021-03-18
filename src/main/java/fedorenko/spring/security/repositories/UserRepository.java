package fedorenko.spring.security.repositories;

import fedorenko.spring.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select user from User user join fetch user.roles where user.userName = :username")
    User findByUserName(@Param("username") String username);

    @Override
    List<User> findAll();

    @Override
    User getOne(Long aLong);

    @Override
    <S extends User> S save(S s);

    @Override
    void delete(User user);

    @Override
    void deleteById(Long aLong);

    @Override
    Optional<User> findById(Long aLong);
}
