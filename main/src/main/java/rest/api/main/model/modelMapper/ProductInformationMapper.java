package rest.api.main.model.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rest.api.main.entity.ProductInformation;
import rest.api.main.entity.UserInformation;
import rest.api.main.model.modelDTO.ProductInformationDTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductInformationMapper {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ProductInformationDTO toDTO(ProductInformation productInformation) {
        ProductInformationDTO productInformationDTO =  new ProductInformationDTO();
        if (productInformation == null) {
            return productInformationDTO; // or throw an exception, depending on your requirements
        }
        ModelMapper modelMapper = new ModelMapper();
        productInformationDTO = modelMapper.map(productInformation, ProductInformationDTO.class);
        return productInformationDTO;
    }

    public  List<ProductInformationDTO> toDTOList(List<ProductInformation> productInformationList) {
        if (productInformationList == null) {
            return null; // or throw an exception, depending on your requirements
        }
        return productInformationList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public  ProductInformation toEntity(ProductInformationDTO productInformationDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ProductInformation productInformation = modelMapper.map(productInformationDTO, ProductInformation.class);
        return productInformation;
    }
}
