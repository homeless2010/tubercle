package xin.cuichaojiang.tubercle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xin.cuichaojiang.tubercle.system.user.mapper")
public class TubercleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TubercleApplication.class, args);
    }

}
