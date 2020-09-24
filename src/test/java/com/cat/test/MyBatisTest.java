package com.cat.test;
import com.cat.pojo.Students;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class MyBatisTest {
    @Test
    public void  test() throws IOException{
        //获得核心配置文件
        InputStream in = Resources.getResourceAsStream("MyBatisConfig.xml");
        //获得session工厂对象
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session =factory.openSession();
        //获得会话对象
        List<Students> students =session.selectList("com.cat.mapper.listAllStudents");
        System.out.println(students);
        session.close();  //关闭
    }
}

