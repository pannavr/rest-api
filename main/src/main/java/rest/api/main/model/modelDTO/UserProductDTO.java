package rest.api.main.model.modelDTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserProductDTO implements Serializable {
    private Integer userProductId;
    private Integer userId;
    private Integer productId;
    private Integer isActive;
    private String createDate;
    private String modifiedDate;
}
