package rest.api.main.model.modelDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ResponseDataDTO<T> {
    private  String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> listData;
}
