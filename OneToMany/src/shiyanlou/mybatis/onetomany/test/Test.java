package shiyanlou.mybatis.onetomany.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

import shiyanlou.mybatis.onetomany.mapper.ClassesMapper;
import shiyanlou.mybatis.onetomany.model.Classes;
import shiyanlou.mybatis.onetomany.model.Student;


public class Test {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        // Mybatis ????
        String resource = "mybatis.cfg.xml";

        // ???????
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ????????? MyBatis ???????
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // ?????? SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        ClassesMapper mapper = session.getMapper(ClassesMapper.class);
        try {
            Classes classes = mapper.selectClassAndStudentsById(1);
            session.commit();
            System.out.println("Class information: classId: "+classes.getId()+", classname: "+classes.getName());
            List<Student> students = classes.getStudents();
            System.out.println("All the students' info: ");
             for(Student stu:students){
                 System.out.println(stu.getId()+","+stu.getName()+","+stu.getSex()+","+stu.getAge());
             }

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        // ????
        session.close();

    }
}
