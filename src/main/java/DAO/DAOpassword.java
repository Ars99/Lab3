package DAO;

import Entities.LoginPasswordEntity;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DAOpassword{
    public void addUser(LoginPasswordEntity user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public boolean isContain(String login, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<LoginPasswordEntity> users = session.createQuery("from LoginPasswordEntity").list();
        tx1.commit();
        session.close();
        for(LoginPasswordEntity user : users){
            if(user.getLogin().equals(login) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    public List<LoginPasswordEntity> findAll(){
        List<LoginPasswordEntity> users = (List<LoginPasswordEntity>) HibernateUtil.getSessionFactory().openSession().createQuery("From LoginPasswordEntity ").list();
        return users;
    }
}
