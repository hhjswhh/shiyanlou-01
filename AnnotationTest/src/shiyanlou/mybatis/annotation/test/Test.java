package shiyanlou.mybatis.annotation.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import shiyanlou.mybatis.annotation.mapper.UserMapper;
import shiyanlou.mybatis.annotation.model.User;

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

        insertUser();
        // updateUser();
        // deleteUser();
        // selectUserById();
        // selectAllUser();

    }

    // ????
    private static void insertUser(){
        // ?????? SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("Anne");
        user.setSex("female");
        user.setAge(23);
        try {
            mapper.insertUser(user);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        // ????
        session.close();
    }

    // ?id?1?????????25
    private static void updateUser(){
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = null;
        try {
            user = mapper.selectUserById(1);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        user.setAge(25);
        try {
            mapper.updateUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }

    // ?id?5?????
    private static void deleteUser(){
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(5);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }

    // ??id?1?????
    private static void selectUserById(){
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            User user = mapper.selectUserById(1);
            session.commit();
            System.out.println(user.getId() + " " + user.getName()  + " " + user.getSex() + " "
                    + user.getAge());
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }

    // ????????
    private static void selectAllUser(){
        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            List<User> userList = mapper.selectAllUser();
            session.commit();
            for (User user : userList) {
                System.out.println(user.getId() + " " + user.getName()  + " " + user.getSex() + " "
                        + user.getAge());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }
}
