package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.*;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Transaction transaction = null;
    SessionFactory sessionFactory = Util.SesFac();
    Session session = sessionFactory.openSession();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        transaction = (Transaction) session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users(id BIGINT NOT NULL AUTO_INCREMENT," +
                            "name VARCHAR (45)NOT NULL, lastname VARCHAR (45) NOT NULL," +
                        "age TINYINT NOT NULL, PRIMARY KEY (id))").
                        executeUpdate();
        try {
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                try {
                    transaction.rollback();
                } catch (SystemException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
