package rest.api.main.model.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SellingCalculateDTO {
        private Integer productId;
        private String productName;
        private Long totalSales;

}
