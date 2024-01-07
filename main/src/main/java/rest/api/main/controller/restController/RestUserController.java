package rest.api.main.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rest.api.main.model.modelDTO.ResponseDataDTO;
import rest.api.main.model.modelDTO.UserInformationDTO;
import rest.api.main.service.UserInformationService;

@RestController
@RequestMapping("/rest")
public class RestUserController {
    @Autowired
    UserInformationService userInformationService;

    @GetMapping("/user/finByID/{id}")
    public ResponseEntity<ResponseDataDTO> findByID(@PathVariable Integer id) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(userInformationService.findOne(id));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/user/findAll")
    public ResponseEntity<ResponseDataDTO> findAllUser() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(userInformationService.findAll());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/user/user/active")
    public ResponseEntity<ResponseDataDTO> findUserActive() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(userInformationService.findUserActive());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/user/findByName/{name}")
    public ResponseEntity<ResponseDataDTO> findByName(@PathVariable String name) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(userInformationService.findByName(name, name));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/user/save")
    public ResponseEntity<ResponseDataDTO> saveUser(@RequestBody UserInformationDTO userInformationDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(userInformationService.saveData(userInformationDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/user/non/Active")
    public ResponseEntity<ResponseDataDTO> nonActiveUser(@RequestBody UserInformationDTO userInformationDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(userInformationService.nonActiveUser(userInformationDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }


    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<ResponseDataDTO> deleteUser(@PathVariable Integer id) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(userInformationService.deletUser(id));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }


    @GetMapping("/error/Test")
    public void badRequest() {
        // Simulate a scenario that triggers a bad request
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Custom Bad Request Message");
    }

}
