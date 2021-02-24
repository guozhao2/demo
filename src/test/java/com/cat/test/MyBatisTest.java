package com.cat.test;
import com.cat.dao.StudentsMapper;
import com.cat.pojo.Students;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    //输出所有学生信息
    @Test
    public void  test() throws IOException{
        //获得核心配置文件
        InputStream in = Resources.getResourceAsStream("MyBatisConfig.xml");
        //获得session工厂对象
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session =factory.openSession();
        //获得会话对象
        List<Students> students =session.selectList("listAllStudents");
        System.out.println(students);
        session.close();  //关闭
    }

    //测试删除一名学生信息
    @Test
    public void deleteStudent() throws  IOException{
        //获得核心配置文件
        InputStream in = Resources.getResourceAsStream("MyBatisConfig.xml");
        //获得session工厂对象
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session =factory.openSession();
        //获得会话对象
        StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);
        studentsMapper.deleteStudent(1000);  //调用deleteStudent方法，删除id是1000的这个学生
        session.close();  //关闭
    }

    //新增一名学生信息
    @Test
    public void addStudent() throws  IOException{
        //获得核心配置文件
        InputStream in = Resources.getResourceAsStream("MyBatisConfig.xml");
        //获得session工厂对象
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session =factory.openSession();
        //获得会话对象
        StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);
        //构造一个新的学生
        Students s =new Students();

        s.setStu_name("呵呵");
        s.setClass_id(1042);
        s.setAge(16);
        s.setStu_sex("男");

        int res = studentsMapper.addStudent(s);  //调用

        session.commit(); //增删改必须提交事务
        session.close();  //关闭
    }

    //修改一名学生信息
    @Test
    public  void updateStudent() throws  IOException{
        //获得核心配置文件
        InputStream in = Resources.getResourceAsStream("MyBatisConfig.xml");
        //获得session工厂对象
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session =factory.openSession();
        //获得会话对象
        StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);

        //把原来的学生信息修改
        Students s= new Students();
        s.setId(1001);  //定向修改id是1001的学生
        s.setStu_name("李十三"); //这个人的名字改成李十三
        s.setStu_sex("男"); //性别改为男
        s.setAge(24); //年龄修改为24
        s.setClass_id(3002);

        int res = studentsMapper.updateStudentById(s);  //调用
        session.commit(); //增删改必须提交事务
        session.close();  //关闭
    }

}

