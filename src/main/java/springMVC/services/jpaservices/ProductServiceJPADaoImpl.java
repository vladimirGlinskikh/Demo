package springMVC.services.jpaservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springMVC.domain.Product;
import springMVC.services.ProductService;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJPADaoImpl extends AbstractJpaDaoService implements ProductService {

    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();
        return savedProduct;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }
}
