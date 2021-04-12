package github.com.jhuynh13.SalesManager;

import org.springframework.data.jpa.repository.JpaRepository;

//SalesInterface's purpose is to tell JPA repo about the existence of 
//Customer and id, like a link between the two
//Extending JPA repo to use CRUD methods
public interface SalesInterface extends JpaRepository<Customers, Long>{

}
