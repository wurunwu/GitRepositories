package wu.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import wu.*;
/**
 * Spring Data Redis测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisApp.class)
public class RedisTest3 {

    @Autowired
    private RedisTemplate<String,Object> rt;

    //添加一个字符串
    @Test
    public void testSet(){
        System.out.println("进入添加一个字符串******************");
        this.rt.opsForValue().set("one","毛毛");
        System.out.println("添加字符串的值:"+this.rt.opsForValue().get("one"));
    }
}
