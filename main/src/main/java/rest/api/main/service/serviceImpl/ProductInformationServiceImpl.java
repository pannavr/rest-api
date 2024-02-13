package rest.api.main.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import rest.api.main.entity.ProductInformation;
import rest.api.main.model.modelDTO.ProductInformationDTO;
import rest.api.main.model.modelMapper.ProductInformationMapper;
import rest.api.main.repository.ProductInformationRepository;
import rest.api.main.service.ProductInformationService;

import java.util.List;

@Service
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    ProductInformationRepository productInformationRepository;

    @Autowired
    ProductInformationMapper productInformationMapper;

    @Override
    @Cacheable(cacheNames = "productinformation", key = "#id")
    public ProductInformationDTO findOne(Integer id) {
        return productInformationMapper.toDTO(productInformationRepository.findById(id).orElse(null));
    }

    @Override
    public List<ProductInformationDTO> finAll() {
        return productInformationMapper.toDTOList(productInformationRepository.findAll());
    }

    @Override
    public List<ProductInformationDTO> findProductActive() {
        List<ProductInformation> productInformation = productInformationRepository.findAll().stream().filter(product -> product.getIsActive().equals(0)).toList();
        return productInformationMapper.toDTOList(productInformation);
    }

    @Override
    @CachePut(cacheNames = "productinformationDTO", key = "#id")
    public ProductInformationDTO saveData(ProductInformationDTO productInformationDTO) {
        productInformationRepository.save(productInformationMapper.toEntity(productInformationDTO));
        return productInformationDTO;
    }

    @Override
    @CachePut(cacheNames = "productinformationDTO", key = "#id")
    public ProductInformationDTO nonActiveProduct(ProductInformationDTO productInformationDTO) {
        if( productInformationRepository.findById(productInformationDTO.getProductId()).orElse(null) == null ){
            throw new RuntimeException("Product "+ productInformationDTO.getProductId() +" tidak ditemukan");
        }
        ProductInformation productInformation = productInformationMapper.toEntity(productInformationDTO);
        productInformation.setIsActive(1);
        productInformationDTO.setIsActive(1);
        productInformationRepository.save(productInformation);
        return productInformationDTO;
    }

    @Override
    @CacheEvict(cacheNames = "productinformationDTO", key = "#id")
    public ProductInformationDTO deleteProduct(Integer id) {
        ProductInformationDTO productInformationDTO = productInformationMapper.toDTO(productInformationRepository.findById(id).orElse(null));
        productInformationRepository.deleteById(id);
        return productInformationDTO;
    }
}
