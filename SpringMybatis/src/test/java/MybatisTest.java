import com.yy.mapper.UserMapper;
import com.yy.pojo.User;
import com.yy.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class MybatisTest {
    @Autowired
    private UserService userService;
    @Test
    public void test01() throws IOException {
        String resource="mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUser();
        for(User user:userList){
            System.out.println(user);
        }
        sqlSession.close();
        in.close();
    }

    @Test
    public void test02(){
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapperImpl = applicationContext.getBean("userMapperImpl", UserMapper.class);
        List<User> userList = userMapperImpl.selectUser();
        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void test03(){
        User user=new User();
        user.setName("Tommy");
        user.setId(10);
        user.setPassword("87654321");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dao.xml");
        System.out.println(applicationContext.getBean("userMapperImpl", UserMapper.class).addUser(user));
    }
    @Test
    public void test04(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-dao.xml");
        System.out.println(applicationContext.getBean("userMapperImpl", UserMapper.class).deleteUser(10));
    }

    @Test
    public void test05() {
        userService.Operation01();
    }
}
