package fedorenko.spring.security.service;

import fedorenko.spring.security.dao.Dao;

import fedorenko.spring.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ServiceImpl implements Service {

    @Autowired
    private Dao dao;

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public List<User> getList() {
        return dao.getList();
    }

    @Override
    public void deleteUser(Long id) {
        User user = dao.show(id);
        dao.remove(user);
    }

    @Override
    public User show(Long id) {
        return dao.show(id);
    }

    @Override
    public void update(User user, Long id) {
        User updateUser= dao.show(id);
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        dao.merge(updateUser);
    }
}
