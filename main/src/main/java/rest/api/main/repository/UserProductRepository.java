package rest.api.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rest.api.main.entity.UserProduct;

import java.util.List;

@Repository
public interface UserProductRepository extends JpaRepository<UserProduct, Integer> {


    @Query(value = "SELECT p.product_id as productId, p.product_name as productName, COUNT(up.user_product_id) AS totalSales " +
            "FROM tb_product_information p " +
            "JOIN tb_user_product up ON p.product_id = up.product_id " +
            "WHERE (:month IS NULL OR MONTH(up.create_date) = :month) " +
            "AND (:year IS NULL OR YEAR(up.create_date) = :year) " +
            "GROUP BY p.product_id, p.product_name " +
            "ORDER BY totalSales DESC", nativeQuery = true)
    List sellingCalculate(@Param("month") Integer month, @Param("year") Integer year);


}
