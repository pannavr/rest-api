package rest.api.main.model.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rest.api.main.entity.UserInformation;
import rest.api.main.model.modelDTO.UserInformationDTO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserInformationMapper {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public  UserInformationDTO toDTO(UserInformation userInformation) {
        ModelMapper modelMapper = new ModelMapper();
        UserInformationDTO userInformationDTO = new UserInformationDTO();
        if (userInformation == null) {
            return userInformationDTO;
        }
        userInformationDTO = modelMapper.map(userInformation, UserInformationDTO.class);
        return userInformationDTO;
    }

    public  List<UserInformationDTO> toDTOList(List<UserInformation> userInformationList) {
        if (userInformationList == null) {
            List<UserInformationDTO> newList = new LinkedList<>();
            return newList;
        }
        return userInformationList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserInformation toEntity(UserInformationDTO userInformationDTO) {
        ModelMapper modelMapper = new ModelMapper();
        UserInformation userInformation = modelMapper.map(userInformationDTO, UserInformation.class);
        return userInformation;
    }

}
