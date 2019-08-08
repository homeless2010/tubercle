package xin.cuichaojiang.tubercle.redis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private ReactiveStringRedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        ReactiveHashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        Mono mono1 = hashOps.put("apple", "中文", "6000");
        mono1.subscribe(System.out::println);
        Mono mono2 = hashOps.put("apple", "xr", "5000");
        mono2.subscribe(System.out::println);
        Mono mono3 = hashOps.put("apple", "xs max", "8000");
        mono3.subscribe(System.out::println);
    }

}
