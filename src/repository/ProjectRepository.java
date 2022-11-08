/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Project;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ppolo
 */
public class ProjectRepository {
    public boolean insert(Project proj) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                session.save(proj);
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

    public boolean update(Project proj) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                session.update(proj);
                tran.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
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
                TypedQuery<Project> query = session.createQuery("DELETE FROM Project p WHERE p.projectId = :id");
                query.setParameter("id", id);
                query.executeUpdate();
                tran.commit();
                return true;
            } catch (Exception e) {
                tran.rollback();
                e.printStackTrace();
                return false;
            } finally {
                session.close();
            }
        }
    }

    public List<Project> selectAll() {
        List<Project> projs;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<Project> query = session.createQuery("FROM Project p");
            projs = query.getResultList();
            session.close();
        }
        return projs;
    }
}