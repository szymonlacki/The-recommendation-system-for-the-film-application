package pl.example.netflix.springapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.example.netflix.springapp.dto.AccountDTO;
import pl.example.netflix.springapp.dto.ActorDTO;
import pl.example.netflix.springapp.dto.UserDetailDTO;
import pl.example.netflix.springapp.service.UserService;

import java.util.List;


@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/user")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity registration(@RequestBody UserDetailDTO userDetailDTO){
        try {
            UserDetailDTO userDetailResult = userService.registration(userDetailDTO);
            return new ResponseEntity(userDetailResult, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    private ResponseEntity getUsers(){
        try {
            List<UserDetailDTO> userDetailDTOList = this.userService.getUsers();
            return new ResponseEntity(userDetailDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity login(@RequestBody AccountDTO accountDTO){
        try {
            UserDetailDTO userDetailDTO = userService.login(accountDTO);
            return new ResponseEntity(userDetailDTO, HttpStatus.OK);
        }
        /*catch(InvalidPasswordException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }*/
        catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{userDetailId}", method = RequestMethod.PATCH)
    private ResponseEntity updateUserAccount(@PathVariable("userDetailId") Long userDetailId, @RequestBody UserDetailDTO userDetailDTO){
        try {
            this.userService.updateUserAccount(userDetailId, userDetailDTO);

            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{userDetailId}", method = RequestMethod.DELETE)
    private ResponseEntity deleteUserAccount(@PathVariable("userDetailId") Long userDetailId){
        try {
            this.userService.deleteUserAccount(userDetailId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "accessRights/{userDetailId}", method = RequestMethod.PATCH)
    private ResponseEntity changeAccessRights(@PathVariable("userDetailId") Long userDetailId, @RequestBody UserDetailDTO userDetailDTO){
        try {
            this.userService.changeAccessRights(userDetailId, userDetailDTO);

            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
