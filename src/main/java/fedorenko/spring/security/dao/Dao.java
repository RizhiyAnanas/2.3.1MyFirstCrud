package fedorenko.spring.security.dao;

import fedorenko.spring.security.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface Dao {
    public void add(User user);
    public List<User> getList();
    public User show(Long id);
    void merge(User user);
    void remove(User user);
}
