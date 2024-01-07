package rest.api.main.model.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductInformationDTO implements Serializable {
    private Integer productId;
    private String productName;
    private Integer productStock;
    private Double productPrice;
    private Integer isActive;
    private String createDate;
    private String modifiedDate;
}
