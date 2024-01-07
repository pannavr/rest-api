package rest.api.main.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.api.main.model.modelDTO.ResponseDataDTO;
import rest.api.main.model.modelDTO.UserProductDTO;
import rest.api.main.service.UserProductService;

@RestController
@RequestMapping("/rest")
public class RestUserProductController {
    @Autowired
    UserProductService userProductService;

    @GetMapping("/userProduct/finByID/{id}")
    public ResponseEntity<ResponseDataDTO> findByID(@PathVariable Integer id) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(userProductService.findOne(id));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/userProduct/findAll")
    public ResponseEntity<ResponseDataDTO> findAllUser() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(userProductService.findAll());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/userProduct/active")
    public ResponseEntity<ResponseDataDTO> findUserActive() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(userProductService.findUserProductActive());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/userProduct/sellingCalculate/{mont}/{year}")
    public ResponseEntity<ResponseDataDTO> sellingCallculate(@PathVariable Integer mont, @PathVariable Integer year) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(userProductService.sellingCalculate(mont,year));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/userProduct/save")
    public ResponseEntity<ResponseDataDTO> saveUser(@RequestBody UserProductDTO userProductDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(userProductService.saveData(userProductDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/userProduct/non/active")
    public ResponseEntity<ResponseDataDTO> nonActiveUser(@RequestBody UserProductDTO userProductDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(userProductService.nonActiveUserProduct(userProductDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }



    @DeleteMapping("/userProduct/delete/{id}")
    public ResponseEntity<ResponseDataDTO> deleteUser(@PathVariable Integer id) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes delete");
        responseDataDTO.setData(userProductService.deleteUserProduct(id));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }
}
