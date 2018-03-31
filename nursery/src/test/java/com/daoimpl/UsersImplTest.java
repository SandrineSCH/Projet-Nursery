package com.daoimpl;

import com.daoapi.UsersDao;
import com.entities.Users;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class UsersImplTest {
    private static ClassPathXmlApplicationContext context;
    private static UsersDao usersDao;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(UsersImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        usersDao = (UsersDao) context.getBean("UsersDao");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        context.close();

    }

    @org.junit.Test
    public void saveOrUpdate() {
        Users newUser = new Users();
        newUser.setUserName("ALLAM");
        newUser.setUserEmail("allam@gmail.com");
        usersDao.saveOrUpdate(newUser);
    }
}
