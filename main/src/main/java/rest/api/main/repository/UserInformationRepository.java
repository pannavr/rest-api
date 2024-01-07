package rest.api.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rest.api.main.entity.UserInformation;

import java.util.List;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {
    @Query(value = "select * from tb_user_information  where first_name like %?1% or last_name like %?2% ", nativeQuery = true)
    List<UserInformation> findByName(String firstName, String lastName);
}
