/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import domainmodel.Employee;
import domainmodel.Project;
import domainmodel.Project_Employee;
import java.util.List;
import java.util.Properties;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ppolo
 */
public class HibernateUtil {

    //Tạo session factory
    private static final SessionFactory FACTORY;

    static {
        //Configuration
        Configuration cfg = new Configuration();

        //Thuộc tính của configuration
        Properties prop = new Properties();
        prop.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        prop.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        prop.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DemoHibernate;encrypt=true;trustServerCertificate=true;");
        prop.put(Environment.USER, "sa");
        prop.put(Environment.PASS, "123456");
        prop.put(Environment.SHOW_SQL, "true");
        
//        prop.put(Environment.HBM2DDL_AUTO, "create");

        //set property cho configuration
        cfg.setProperties(prop);
        
        //mapping các class với table trong db
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Project.class);
        cfg.addAnnotatedClass(Project_Employee.class);
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        FACTORY = cfg.buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }

    //close session factory
    public static void shutdown() {
        getSessionFactory().close();
    }
    
    public static void main(String[] args) {
        getSessionFactory();
    }
}