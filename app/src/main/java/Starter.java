import jh.hierarchies.mapped.FictionBook;
import jh.hierarchies.mapped.ScienceBook;
import jh.relations.Animal;
import jh.relations.Aviary;
import jh.relations.Zoo;
import jh.relations.ZooWorker;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
//        init();

//        jpqlExamples();

//        criteriaAPI();

//        hierarchyInsertDataMapped();
//        hierarchyInsertDataSingleTable();
//        hierarchyInsertDataJoin();
        hierarchyInsertDataTablePerClass();
    }

    private static void hierarchyInsertDataTablePerClass() {
        final Configuration configure = new Configuration().configure();
        final SessionFactory sessionFactory = configure.buildSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        jh.hierarchies.tableperclass.ScienceBook sBook = jh.hierarchies.tableperclass.ScienceBook.builder()
                .science("Высшая алгебра")
                .build();

        sBook.setBookTitle("Мат Анализ первый курс");
        sBook.setAuthor("Фихтенгольц");
        sBook.setPublishYear(1978);

        jh.hierarchies.tableperclass.FictionBook fBook = jh.hierarchies.tableperclass.FictionBook.builder().genre("роман").build();
        fBook.setBookTitle("Евгений онегин");
        fBook.setPublishYear(1833);
        fBook.setIsPoem(true);
        fBook.setAuthor("Пушкин");


        entityManager.persist(sBook);
        entityManager.persist(fBook);

        entityManager.createQuery("from Book").getResultStream().forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    private static void hierarchyInsertDataJoin() {
        final Configuration configure = new Configuration().configure();
        final SessionFactory sessionFactory = configure.buildSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        jh.hierarchies.join.ScienceBook sBook = jh.hierarchies.join.ScienceBook.builder()
                .science("Высшая алгебра")
                .build();

        sBook.setBookTitle("Мат Анализ первый курс");
        sBook.setAuthor("Фихтенгольц");
        sBook.setPublishYear(1978);

        jh.hierarchies.join.FictionBook fBook = jh.hierarchies.join.FictionBook.builder().genre("роман").build();
        fBook.setBookTitle("Евгений онегин");
        fBook.setPublishYear(1833);
        fBook.setIsPoem(true);
        fBook.setAuthor("Пушкин");


        entityManager.persist(sBook);
        entityManager.persist(fBook);

        entityManager.createQuery("from Book").getResultStream().forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void hierarchyInsertDataSingleTable() {
        final Configuration configure = new Configuration().configure();
        final SessionFactory sessionFactory = configure.buildSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        jh.hierarchies.single.ScienceBook sBook = jh.hierarchies.single.ScienceBook.builder()
                .science("Высшая алгебра")
                .build();

        sBook.setBookTitle("Мат Анализ первый курс");
        sBook.setAuthor("Фихтенгольц");
        sBook.setPublishYear(1978);

        jh.hierarchies.single.FictionBook fBook = jh.hierarchies.single.FictionBook.builder().genre("роман").build();
        fBook.setBookTitle("Евгений онегин");
        fBook.setPublishYear(1833);
        fBook.setIsPoem(true);
        fBook.setAuthor("Пушкин");


        entityManager.persist(sBook);
        entityManager.persist(fBook);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    private static void hierarchyInsertDataMapped() {
        final Configuration configure = new Configuration().configure();
        final SessionFactory sessionFactory = configure.buildSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        ScienceBook sBook = ScienceBook.builder()
                .science("Высшая алгебра")
                .build();

        sBook.setBookTitle("Мат Анализ первый курс");
        sBook.setAuthor("Фихтенгольц");
        sBook.setPublishYear(1978);

        FictionBook fBook = FictionBook.builder().genre("роман").build();
        fBook.setBookTitle("Евгений онегин");
        fBook.setPublishYear(1833);
        fBook.setIsPoem(true);
        fBook.setAuthor("Пушкин");


        entityManager.persist(sBook);
        entityManager.persist(fBook);

        entityManager.createQuery("from Book").getResultStream().forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    private static void criteriaAPI() {
        final Configuration configure = new Configuration().configure();
        final SessionFactory sessionFactory = configure.buildSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Animal> criteria = cb.createQuery(Animal.class);
        final Root<Animal> from = criteria.from(Animal.class);

        entityManager.createQuery(criteria.select(from)).getResultStream().forEach(System.out::println);

        //------------------------------------------------

        final CriteriaBuilder cb2 = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Animal> criteria2 = cb2.createQuery(Animal.class);
        final Root<Animal> from1 = criteria2.from(Animal.class);
        criteria2.select(from1).where(cb2.equal(from1.get("nickName"), "лапушка"));
        entityManager.createQuery(criteria2).getResultStream().forEach(System.out::println);

        //proection
        final CriteriaBuilder cb3 = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteria3 = cb3.createQuery(Long.class);
        criteria3.select(cb3.count(criteria3.from(Animal.class)));
        long count = entityManager.createQuery(criteria3).getSingleResult();
        System.out.println(count);

        //JOINS

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void jpqlExamples() {
        final Configuration configure = new Configuration().configure();
        final SessionFactory sessionFactory = configure.buildSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        printJpqlResults(entityManager, "from Animal");

        printJpqlResults(entityManager, "select a.nickName from  Animal a");

        printJpqlResults(entityManager, "from Animal where name like 'лягушка%'");

        printJpqlResults(entityManager, "from Animal where name like 'лягушка%' order by name asc");

        Query query = entityManager.createQuery("select count(a), a.groupName from Animal a group by a.groupName");
        final List resultList = query.getResultList();
        final Iterator iterator = resultList.iterator();
        while (iterator.hasNext()) {
            final Object[] next = (Object[]) iterator.next();
            System.out.println(next[0] + " " + next[1]);
        }

        Query query1 = entityManager.createQuery("select a.nickName from Animal a where a.id = :animal_id");
        query1.setParameter("animal_id", 1);
        query1.getResultStream().forEach(System.out::println);

        Query query2 = entityManager.createQuery("update Animal a set a.nickName = :newNickName where a.id = :animal_id");
        query2.setParameter("newNickName", "красавец");
        query2.setParameter("animal_id", 3);
        query2.executeUpdate();

        printJpqlResults(entityManager, "select a.nickName from  Animal a");

        System.out.println("--------Named Query-------");
        final Query getAnimalById = entityManager.createNamedQuery("get_animal_by_id");
        getAnimalById.setParameter("animal_id", 1);
        getAnimalById.getResultStream().forEach(System.out::println);


        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void printJpqlResults(EntityManager entityManager, String jpql) {
        Query query = entityManager.createQuery(jpql);
        query.getResultStream().forEach(System.out::println);
    }

    private static void init() {
        final Configuration configure = new Configuration().configure();
        final SessionFactory sessionFactory = configure.buildSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Zoo minskZoo = Zoo.builder()
                .name("Минский зоопарк")
                .build();

        entityManager.persist(minskZoo);

        final ZooWorker zooWorker = ZooWorker.builder()
                .fullName("Петр Петрович")
                .salary(500)
                .zoo(minskZoo)
                .build();

        final ZooWorker zooWorker2 = ZooWorker.builder()
                .fullName("Иван Иванов")
                .salary(600)
                .zoo(minskZoo)
                .build();

        entityManager.persist(zooWorker);
        entityManager.persist(zooWorker2);

        Aviary aviary = new Aviary("Лягушки"
                , null
                , null
                ,minskZoo);

        Aviary aviary1 = new Aviary("Тигры"
                , null
                , null
                ,minskZoo);

        entityManager.persist(aviary);
        entityManager.persist(aviary1);

        final Animal frog = new Animal( "лягушка европейская", "бесхвостые земноводные", "лапушка");
        final Animal frog1 = new Animal( "лягушка белорусская", "бесхвостые земноводные", "пятнистая");
        final Animal frog2 = new Animal( "лягушка бразильская", "бесхвостые земноводные", "уродец");

        entityManager.persist(frog);
        entityManager.persist(frog1);
        entityManager.persist(frog2);


        aviary.setAnimals(new HashSet<>(List.of(frog, frog1, frog2)));
        aviary.setWorkers(new HashSet<>(List.of(zooWorker, zooWorker2)));
        entityManager.merge(aviary);


        final Animal tiger1 = new Animal( "тигр", "кошачьи", "1");
        final Animal tiger2 = new Animal( "тигр", "кошачьи", "2");

        entityManager.persist(tiger1);
        entityManager.persist(tiger2);

        aviary1.setAnimals(new HashSet<Animal>(List.of(tiger1, tiger2)));
        aviary1.setWorkers(new HashSet<ZooWorker>(List.of(zooWorker, zooWorker2)));

        entityManager.merge(aviary1);


        transaction.commit();
        entityManager.close();
    }

    private static void filing_relational_tables() {
        Configuration configuration = new Configuration().configure();
        final SessionFactory sessionFactory = configuration.buildSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Zoo minskZoo = Zoo.builder()
                .name("Минский зоопарк")
                .build();

        entityManager.persist(minskZoo);


        final Animal frog = new Animal( "лягушка европейская", "бесхвостые земноводные", "лапушка");
        final Animal frog1 = new Animal( "лягушка белорусская", "бесхвостые земноводные", "пятнистая");
        final Animal frog2 = new Animal( "лягушка бразильская", "бесхвостые земноводные", "уродец");


        final ZooWorker zooWorker = ZooWorker.builder()
                .fullName("Петр Петрович")
                .salary(500)
                .zoo(minskZoo)
                .build();

        final ZooWorker zooWorker2 = ZooWorker.builder()
                .fullName("Иван Иванов")
                .salary(600)
                .zoo(minskZoo)
                .build();


        Aviary aviary = new Aviary("Лягушки"
                , new HashSet<Animal>(List.of(frog, frog1, frog2))
                , new HashSet<ZooWorker>(List.of(zooWorker)), minskZoo);

        final Aviary mergeAviary = entityManager.merge(aviary);

        final Animal tiger1 = new Animal( "тигр", "кошачьи", "1");
        final Animal tiger2 = new Animal( "тигр", "кошачьи", "2");

        Aviary aviary1 = new Aviary("Тигры"
                , new HashSet<Animal>(List.of(tiger1, tiger2))
                , new HashSet<ZooWorker>(List.of(zooWorker, zooWorker2)), minskZoo);


        entityManager.persist(aviary1);


        transaction.commit();
        entityManager.close();
    }
}

