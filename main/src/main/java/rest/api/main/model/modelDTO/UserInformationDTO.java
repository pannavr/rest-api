package rest.api.main.model.modelDTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInformationDTO implements Serializable {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private Integer isActive;
    private String createDate;
    private String modifiedDate;
}
