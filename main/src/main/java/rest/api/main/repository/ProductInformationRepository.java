package rest.api.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.api.main.entity.ProductInformation;

@Repository
public interface ProductInformationRepository extends JpaRepository<ProductInformation, Integer> {

}
