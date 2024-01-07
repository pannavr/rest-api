package rest.api.main.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.api.main.model.modelDTO.ProductInformationDTO;
import rest.api.main.model.modelDTO.ResponseDataDTO;
import rest.api.main.service.ProductInformationService;

@RestController
@RequestMapping("/rest")
public class RestProductController {
    @Autowired
    ProductInformationService productInformationService;

    @GetMapping("/product/finByID/{id}")
    public ResponseEntity<ResponseDataDTO> findByID(@PathVariable Integer id) {
        System.out.println(id);
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(productInformationService.findOne(id));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/product/findAll")
    public ResponseEntity<ResponseDataDTO> findAllUser() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(productInformationService.finAll());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/product/active")
    public ResponseEntity<ResponseDataDTO> findUserActive() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(productInformationService.findProductActive());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/product/save")
    public ResponseEntity<ResponseDataDTO> saveUser(@RequestBody ProductInformationDTO productInformationDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(productInformationService.saveData(productInformationDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/product/non/active")
    public ResponseEntity<ResponseDataDTO> nonActiveUser(@RequestBody ProductInformationDTO productInformationDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(productInformationService.nonActiveProduct(productInformationDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }


    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<ResponseDataDTO> deleteUser(@PathVariable Integer id) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(productInformationService.deleteProduct(id));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }
}
