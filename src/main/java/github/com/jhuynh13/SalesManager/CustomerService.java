package github.com.jhuynh13.SalesManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class CustomerService {
	
	//inject instance of salesinterface using autowired annotation
	//at runtime, jpa will inject instance of salesinterface into customerservice
	@Autowired
    private SalesInterface repo;
     
    public List<Customers> listAll() {
        return repo.findAll();
    }
     
    public void save(Customers customer) {
        repo.save(customer);
    }
     
    public Customers get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
