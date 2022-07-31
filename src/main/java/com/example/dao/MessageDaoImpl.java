package com.example.dao;

import java.util.List;
import com.example.exception.DataProcessingException;
import com.example.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl implements MessageDao {
    protected final SessionFactory factory;

    public MessageDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Message save(Message message) {
        Transaction transaction = null;
        Session session = null;
        try  {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(message);
            transaction.commit();
            return message;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save the massage", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Message> getAllMessages() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Message m ORDER BY m.time ASC", Message.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all messages from db", e);
        }
    }

    @Override
    public List<Message> getFiftyMessages() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Message m ORDER BY m.time ASC", Message.class)
                    .setMaxResults(50)
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all messages from db", e);
        }
    }

    @Override
    public void delete(Integer id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Message message = session.get(Message.class, id);
            session.delete(message);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete the massage with id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
