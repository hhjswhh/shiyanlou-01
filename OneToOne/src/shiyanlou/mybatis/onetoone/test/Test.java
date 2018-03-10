package shiyanlou.mybatis.onetoone.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import shiyanlou.mybatis.onetoone.mapper.ClassesMapper;
import shiyanlou.mybatis.onetoone.model.Classes;

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
            Classes classes = mapper.selectClassById(1);
            session.commit();
            System.out.println(classes.getId() + "," + classes.getName() + ",["
                    + classes.getTeacher().getId() + ","
                    + classes.getTeacher().getName() + ","
                    + classes.getTeacher().getAge()+"]");

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        // ????
        session.close();

    }
}
