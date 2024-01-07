package rest.api.main.model.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.api.main.entity.UserProduct;
import rest.api.main.model.modelDTO.UserProductDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserProductMapper {

    public UserProductDTO toDTO(UserProduct userProduct) {
        UserProductDTO userProductDTO = new UserProductDTO();
        if (userProduct == null) {
            return userProductDTO;
        }
        ModelMapper modelMapper = new ModelMapper();
        userProductDTO = modelMapper.map(userProduct, UserProductDTO.class);
        return userProductDTO;
    }

    public List<UserProductDTO> toDTOList(List<UserProduct> userProductList) {
        if (userProductList == null) {
            return null; // or throw an exception, depending on your requirements
        }
        return userProductList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserProduct toEntity(UserProductDTO userProductDTO) {
        ModelMapper modelMapper = new ModelMapper();
        UserProduct userProduct = modelMapper.map(userProductDTO, UserProduct.class);
        return userProduct;
    }

}
