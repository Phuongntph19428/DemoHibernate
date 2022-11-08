/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Project_Employee;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ppolo
 */
public class PERepository {
    public boolean insert(Project_Employee pe) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                session.save(pe);
                tran.commit();
                return true;
            } catch (Exception e) {
                tran.rollback();
                return false;
            } finally {
                session.close();
            }
        }
    }

    public boolean update(Project_Employee pe) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                session.update(pe);
                tran.commit();
                return true;
            } catch (Exception e) {
                tran.rollback();
                return false;
            } finally {
                session.close();
            }
        }
    }

    public boolean delete(int id) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                TypedQuery<Project_Employee> query = 
                        session.createQuery("DELETE FROM Project_Employee p WHERE p.id = :id", Project_Employee.class);
                query.setParameter("id", id);
                query.executeUpdate();
                tran.commit();
                return true;
            } catch (Exception e) {
                tran.rollback();
                return false;
            } finally {
                session.close();
            }
        }
    }

    public List<Project_Employee> selectAll() {
        List<Project_Employee> pes;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<Project_Employee> query = session.createQuery("FROM Project_Employee p");
            pes = query.getResultList();
            session.close();
        }
        return pes;
    }
}

