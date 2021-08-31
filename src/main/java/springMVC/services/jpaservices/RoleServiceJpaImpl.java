package springMVC.services.jpaservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springMVC.domain.security.Role;
import springMVC.services.RoleService;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class RoleServiceJpaImpl extends AbstractJpaDaoService implements RoleService {
    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Role.class, id);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Role saveRole = em.merge(domainObject);
        em.getTransaction().commit();

        return saveRole;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Role.class, id));
        em.getTransaction().commit();
    }
}
