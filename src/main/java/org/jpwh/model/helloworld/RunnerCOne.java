package org.jpwh.model.helloworld;

import javax.persistence.EntityManager;
import java.util.List;


public class RunnerCOne {
    public static void main(String[] args) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        final List<Message> messages = entityManager.createQuery("select m from Message m").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void persistMessage() {
        Message message = Message.builder()
                //org.hibernate.PersistentObjectException: detached entity passed to persist
//                .id(1L) //persist operation is intended for brand new transient objects and it fails if id is already assigned
                .text("Hello")
                .build();
        System.out.println(message);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(message);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
