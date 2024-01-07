package rest.api.main.service;

import org.springframework.stereotype.Service;
import rest.api.main.model.modelDTO.ProductInformationDTO;
import rest.api.main.model.modelDTO.UserInformationDTO;

import java.util.List;

@Service
public interface ProductInformationService {
    public ProductInformationDTO findOne(Integer id);

    public List<ProductInformationDTO> finAll();

    public List<ProductInformationDTO> findProductActive();

    public ProductInformationDTO saveData(ProductInformationDTO productInformationDTO);

    public ProductInformationDTO nonActiveProduct(ProductInformationDTO productInformationDTO);

    public ProductInformationDTO deleteProduct(Integer id);

}
