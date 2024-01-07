package rest.api.main.service;

import org.springframework.stereotype.Service;
import rest.api.main.model.modelDTO.SellingCalculateDTO;
import rest.api.main.model.modelDTO.UserProductDTO;

import java.util.List;

@Service
public interface UserProductService {

    public UserProductDTO findOne(Integer id);

    public List<UserProductDTO> findAll();

    public List<UserProductDTO> findUserProductActive();

    public UserProductDTO saveData(UserProductDTO userProductDTO);

    public UserProductDTO nonActiveUserProduct(UserProductDTO userProductDTO);

    public List<SellingCalculateDTO> sellingCalculate(Integer month, Integer year);

    public UserProductDTO deleteUserProduct(Integer id);

}
