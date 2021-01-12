import com.ssm.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void findUserByIdTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(2);
        user.setUsername("lisi");
        user.setJobs("chushi");
        user.setPhone("13333333333");
        int rows = sqlSession.insert("com.ssm.mapper.UserMapper.updateUser", user);
        if (rows > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
