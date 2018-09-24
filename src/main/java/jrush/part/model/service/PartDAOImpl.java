package jrush.part.model.service;

import jrush.part.model.dao.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PartDAOImpl implements PartDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Part> list() {
        Session session = sessionFactory.openSession();

        // session.createCriteria deprecated, используем билдер
        CriteriaBuilder cb = session.getCriteriaBuilder();
        // создаем объект query
        CriteriaQuery<Part> cq = cb.createQuery(Part.class);
        // указываем таблицу
        Root<Part> root = cq.from(Part.class);

        // указываем, какой тип должен возвращаться в запросе
        cq.select(root);

        // готовим запрос к исполнению
        Query<Part> query = session.createQuery(cq);

        return query.list();
    }
}
