package xin.cuichaojiang.tubercle.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import xin.cuichaojiang.tubercle.system.user.model.User;
import xin.cuichaojiang.tubercle.system.user.repository.UserRepository;

import javax.annotation.Resource;
import java.text.DateFormat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTests {
    @Resource
    private UserRepository userRepository;

    @Test
    public void testSave() {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        userRepository.save(new User("2", "aa123456", "aaaaaa", "aaaaa"));
        userRepository.save(new User("3", "bb123456", "bbbbbb", "bbbbb"));
        userRepository.save(new User("4", "cc123456", "cccccc", "cccccc"));

    }


    @Test
    public void testBaseQuery() {
        userRepository.findAll();
        userRepository.findById("1");
    }

    @Test
    public void testCustomSql() {
        userRepository.modifyById("neo", "1");
        userRepository.deleteById("1");
    }


    @Test
    public void testPageQuery() {
        int page = 1, size = 2;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        userRepository.findALL(pageable);
        userRepository.findByLoginName("aa", pageable);
    }

}
