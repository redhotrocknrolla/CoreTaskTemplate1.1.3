package jm.task.core.jdbc.util;




import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String Url = "jdbc:mysql://localhost/";
    private static final String Username = "root";
    private static final String Password = "76315as";
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory;

    public static SessionFactory SesFac(){
        try {
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, Driver);
            settings.put(Environment.URL, Url);
            settings.put(Environment.USER, Username);
            settings.put(Environment.PASS, Password);
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.HBM2DDL_AUTO, "create-drop");
            sessionFactory = new Configuration().setProperties(settings).addAnnotatedClass(User.class).buildSessionFactory();
        } catch (Exception exception) {
            throw new ExceptionInInitializerError();

        } return sessionFactory;
    }

    public static Connection getConnection()  {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Url, Username, Password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
