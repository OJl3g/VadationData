package org.OJl3g;

import org.OJl3g.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit(); //закрываем Transaction
        session.close(); //закрываем текущею сессию
    }
}
