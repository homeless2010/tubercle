package xin.cuichaojiang.tubercle.system.user.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import xin.cuichaojiang.tubercle.system.user.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Cacheable(value = "user", keyGenerator = "keyGenerator", unless = "#result eq null")
    Optional<User> findById(String id);

    @CachePut(value = "user",  unless = "#result eq null")
    User save(User user);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    @CacheEvict(value = "user", key = "#id")
    void deleteById(String id);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update User set name = ?1 where id = ?2")
    int modifyById(String name, String id);

    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    Page<User> findByLoginName(String loginName, Pageable pageable);

}
