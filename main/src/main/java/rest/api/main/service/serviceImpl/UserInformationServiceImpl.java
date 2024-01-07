package rest.api.main.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import rest.api.main.entity.UserInformation;
import rest.api.main.model.modelDTO.UserInformationDTO;
import rest.api.main.model.modelMapper.UserInformationMapper;
import rest.api.main.repository.UserInformationRepository;
import rest.api.main.service.UserInformationService;

import java.util.List;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    UserInformationRepository userInformationRepository;

    @Autowired
    UserInformationMapper userInformationMapper;

    @Override
    @Cacheable(cacheNames = "userinformationDTO", key = "#id")
    public UserInformationDTO findOne(Integer id) {
        return userInformationMapper.toDTO(userInformationRepository.findById(id).orElse(null));
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "userinformationDTO", key = "0")
            },
            evict = {
                    @CacheEvict(cacheNames = "userinformationDTO", allEntries = true)
            }
    )
    public List<UserInformationDTO> findAll() {
        return userInformationMapper.toDTOList(userInformationRepository.findAll());
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "userinformationDTO", key = "0")
            },
            evict = {
                    @CacheEvict(cacheNames = "userinformationDTO", allEntries = true)
            }
    )
    public List<UserInformationDTO> findUserActive() {
        List<UserInformation> userInformation = userInformationRepository.findAll().stream().filter(userInf -> userInf.getIsActive().equals(0)).toList();
        return userInformationMapper.toDTOList(userInformation);
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "userinformationDTO", key = "0")
            },
            evict = {
                    @CacheEvict(cacheNames = "userinformationDTO", allEntries = true)
            }
    )
    public UserInformationDTO saveData(UserInformationDTO userInformationDTO) {
        userInformationRepository.save(userInformationMapper.toEntity(userInformationDTO));
        return userInformationDTO;
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "userinformationDTO", key = "0")
            },
            evict = {
                    @CacheEvict(cacheNames = "userinformationDTO", allEntries = true)
            }
    )
    public List<UserInformationDTO> findByName(String firstName, String lastName) {
        return userInformationMapper.toDTOList(userInformationRepository.findByName(firstName, lastName));
    }

    @Override
    @CachePut(cacheNames = "userinformationDTO")
    public UserInformationDTO nonActiveUser(UserInformationDTO userInformationDTO) {
       if( userInformationRepository.findById(userInformationDTO.getUserId()).orElse(null) == null ){
           throw new RuntimeException("User "+userInformationDTO.getUserId()+ "tidak ditemukan");
       }
        UserInformation userInformation = userInformationMapper.toEntity(userInformationDTO);
        userInformation.setIsActive(1);
        userInformationDTO.setIsActive(1);
        userInformationRepository.save(userInformation);
        return userInformationDTO;
    }
    @Override
    @CachePut(cacheNames = "userinformationDTO", key = "#id")
    public UserInformationDTO deletUser(Integer id) {
        UserInformationDTO userInformationDTO = userInformationMapper.toDTO(userInformationRepository.findById(id).orElse(null));
        userInformationRepository.deleteById(id);
        return userInformationDTO;
    }
}
