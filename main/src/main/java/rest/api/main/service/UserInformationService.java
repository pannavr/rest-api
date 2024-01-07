package rest.api.main.service;

import org.springframework.stereotype.Service;
import rest.api.main.model.modelDTO.UserInformationDTO;

import java.util.List;

@Service
public interface UserInformationService {

    public UserInformationDTO findOne(Integer id);

    public List<UserInformationDTO> findAll();

    public List<UserInformationDTO> findUserActive();

    public UserInformationDTO saveData(UserInformationDTO userInformationDTO);

    public List<UserInformationDTO> findByName(String firstName, String lastName);

    public UserInformationDTO nonActiveUser(UserInformationDTO userInformationDTO);

    public UserInformationDTO deletUser(Integer id);

}
