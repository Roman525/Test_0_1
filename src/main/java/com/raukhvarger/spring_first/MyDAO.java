package com.raukhvarger.spring_first;

import com.raukhvarger.spring_first.entities.IEntity;
import com.raukhvarger.spring_first.entities.Korzina;
import com.raukhvarger.spring_first.entities.MyEntity;
import com.raukhvarger.spring_first.entities.Polzovatel;
import org.hibernate.query.criteria.internal.predicate.ComparisonPredicate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class MyDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(IEntity myEntity) {
        em.persist(myEntity);
    }

    public List<IEntity> findAll(Class<? extends IEntity > entityClass) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(entityClass);
        Root variableRoot = query.from(entityClass);

        query.select(variableRoot);

        return em.createQuery(query).getResultList();
        //return em.createQuery("SELECT p FROM MyEntity p WHERE id=:id").setParameter("id", (long)1).getResultList();
    }

    public Polzovatel findPol(Polzovatel polzovatel){
        return (Polzovatel) em.createQuery("SELECT p FROM Polzovatel p where p.name = :name AND p.password=:password")
                .setParameter("name",polzovatel.getName())
                .setParameter("password",polzovatel.getPassword())
                .getSingleResult();
    }
    public int insertKor(MyEntity myEntity, Long id){
        return em.createQuery("INSERT INTO Korzina(idtov=:idtov,idpolz)").setParameter("idtov",myEntity.getId()).setParameter("idpolz",id).executeUpdate();
    }

    public int deleteKor(MyEntity myEntity, Long id){
        return em.createQuery("DELETE FROM Korzina k WHERE k.idtov=:idtov AND k.idpolz=:idpolz").setParameter("idtov",myEntity.getId()).setParameter("idpolz",id).executeUpdate();
    }

    public List<IEntity> findAllKor(Long idpolz){
        return em.createQuery("SELECT m FROM MyEntity m LEFT JOIN Korzina K ON K.idtov = m.id WHERE K.idpolz =:idpolz").setParameter("idpolz",idpolz).getResultList();
    }
}
