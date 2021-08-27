package springMVC.services.mapservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springMVC.domain.DomainObject;
import springMVC.domain.Product;
import springMVC.services.ProductService;
import springMVC.services.mapservices.AbstractMapService;

import java.util.List;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
