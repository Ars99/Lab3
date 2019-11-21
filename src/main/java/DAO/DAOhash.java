package DAO;

import Entities.LoginHashEntity;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;

public class DAOhash {
    public void addUser(LoginHashEntity user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public boolean isContain(String login, String hash){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<LoginHashEntity> users = session.createQuery("from LoginHashEntity").list();
        tx1.commit();
        session.close();
        for(LoginHashEntity user : users){
            if(user.getLogin().equals(login) && user.getHash().equals(hash))
                return true;
        }
        return false;
    }

    public boolean isContainHash(String hash){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<LoginHashEntity> users = session.createQuery("from LoginHashEntity").list();
        tx1.commit();
        session.close();
        for(LoginHashEntity user : users){
            if(user.getHash().equals(hash))
                return true;
        }
        return false;
    }

    public String getHash(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<LoginHashEntity> users = session.createQuery("from LoginHashEntity").list();
        String hash = null;
        for (LoginHashEntity user : users) {
            if (user.getLogin().equals(login))
                hash = user.getHash();
        }
        tx1.commit();
        session.close();
        return hash;
    }

    public List<LoginHashEntity> findAll(){
        List<LoginHashEntity> users = (List<LoginHashEntity>) HibernateUtil.getSessionFactory().openSession().createQuery("From LoginHashEntity ").list();
        return users;
    }
}
