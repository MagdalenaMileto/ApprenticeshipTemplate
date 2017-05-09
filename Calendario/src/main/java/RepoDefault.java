import org.hibernate.Criteria;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by fede on 09/05/17.
 */
abstract class RepoDefault<T> {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("calendario");

    public List<T> allInstances() {
        EntityManager entityManager = this.entityManager();
        try {
            CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> query = (CriteriaQuery<T>) criteria.createQuery();
            Root<T> from = query.from(entityType());
            query.select(from);
            return entityManager.createQuery(query).getResultList();
        } finally {
            entityManager.close();
        }

    }

    public abstract Class<T> entityType();

    public List<T> searchByExample(T t) {
        EntityManager entityManager = this.entityManager();
        try {
            CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> query = (CriteriaQuery<T>) criteria.createQuery();
            Root<T> from = query.from(entityType());
            query.select(from);
            generateWhere(criteria, query, from, t);
            return entityManager.createQuery(query).getResultList();
        } finally {
            entityManager.close();
        }
    }

    abstract void generateWhere(CriteriaBuilder criteria, CriteriaQuery<T> query, Root<T> camposCandidato, T t);

    public void create(T t) {
        EntityManager entityManager = this.entityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new RuntimeException("AH, Ha ocurrido un error. JAJAJAJA", e);
        } finally {
            entityManager.close();
        }
    }

    public void update(T t) {
        EntityManager entityManager = this.entityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new RuntimeException("AH, Ha ocurrido un error.", e);
        } finally {
            entityManager.close();
        }
    }

    public EntityManager entityManager() {
        return entityManagerFactory.createEntityManager();
    }
}