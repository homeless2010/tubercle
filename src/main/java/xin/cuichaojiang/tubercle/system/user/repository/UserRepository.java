package xin.cuichaojiang.tubercle.system.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import xin.cuichaojiang.tubercle.system.user.model.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByName(String name);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update User set name = ?1 where id = ?2")
    int modifyById(String name, String id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteById(String id);

    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    Page<User> findByLoginName(String loginName, Pageable pageable);

}
