package rest.api.main.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import rest.api.main.entity.ProductInformation;
import rest.api.main.entity.UserProduct;
import rest.api.main.model.modelDTO.ResourceNotFoundException;
import rest.api.main.model.modelDTO.SellingCalculateDTO;
import rest.api.main.model.modelDTO.UserProductDTO;
import rest.api.main.model.modelMapper.UserProductMapper;
import rest.api.main.repository.ProductInformationRepository;
import rest.api.main.repository.UserProductRepository;
import rest.api.main.service.UserProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProductServiceImpl implements UserProductService {

    @Autowired
    UserProductRepository userProductRepository;

    @Autowired
    ProductInformationRepository productInformationRepository;

    @Autowired
    UserProductMapper userProductMapper;


    @Override
    @Cacheable(cacheNames = "userproductDTO", key = "#id")
    public UserProductDTO findOne(Integer id) {
        return userProductMapper.toDTO(userProductRepository.findById(id).orElse(null));
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "userproductDTO", key = "0")
            },
            evict = {
                    @CacheEvict(cacheNames = "userproductDTO", allEntries = true)
            }
    )
    public List<UserProductDTO> findAll() {
        return userProductMapper.toDTOList(userProductRepository.findAll());
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "userproductDTO", key = "0")
            },
            evict = {
                    @CacheEvict(cacheNames = "userproductDTO", allEntries = true)
            }
    )
    public List<UserProductDTO> findUserProductActive() {
        return userProductMapper.toDTOList(userProductRepository.findAll().stream().filter(userProduct -> userProduct.getIsActive().equals(0)).toList());
    }

    @Override
    @CachePut(cacheNames = "userproductDTO")
    public UserProductDTO saveData(UserProductDTO userProductDTO) {
        ProductInformation productInformation = productInformationRepository.findById(userProductDTO.getProductId()).orElse(null);
       if (productInformation.getProductStock()<1){
           throw new ResourceNotFoundException("Stock habis!");
       }
        productInformation.setProductStock(productInformation.getProductStock()-1);
        productInformationRepository.save(productInformation);
        userProductRepository.save(userProductMapper.toEntity(userProductDTO));
      return userProductDTO;
    }

    @Override
    @CachePut(cacheNames = "userproductDTO")
    public UserProductDTO nonActiveUserProduct(UserProductDTO userProductDTO) {
        if( productInformationRepository.findById(userProductDTO.getUserProductId()).orElse(null) == null ){
            throw new RuntimeException("Data Order "+ userProductDTO.getUserProductId() +" tidak ditemukan");
        }
        UserProduct userProduct = userProductMapper.toEntity(userProductDTO);
        userProduct.setIsActive(1);
        userProductDTO.setIsActive(1);
        userProductRepository.save(userProduct);
        return userProductDTO;
    }
    @Override
    public List<SellingCalculateDTO> sellingCalculate(Integer month, Integer year) {
        List<Object[]> getselling = userProductRepository.sellingCalculate(month, year);
        System.out.println(getselling);
        List<SellingCalculateDTO> sellingCalculateDTOS = getselling.stream()
                .map(t -> new SellingCalculateDTO(
                        ((Number) t[0]).intValue(),
                        (String) t[1],
                        ((Long) t[2]).longValue()
                ))
                .collect(Collectors.toList());
        return sellingCalculateDTOS;
    }

    @Override
    @CacheEvict(cacheNames = "userproductDTO", key = "#id", beforeInvocation = true)
    public UserProductDTO deleteUserProduct(Integer id) {
       UserProductDTO userProductDTO = userProductMapper.toDTO(userProductRepository.findById(id).orElse(null));
        userProductRepository.deleteById(id);
        return userProductDTO;
    }
}
