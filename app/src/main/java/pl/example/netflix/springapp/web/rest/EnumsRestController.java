package pl.example.netflix.springapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.example.netflix.springapp.service.AccessRightService;

import java.util.List;


@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/netflix/rest/enums")
public class EnumsRestController {


    private final AccessRightService accessRightService;

    @Autowired
    public EnumsRestController(AccessRightService accessRightService) {
        this.accessRightService = accessRightService;

    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity getAccessRights(){
        try {
            List<String> accessRightsList = this.accessRightService.getAccessRights();
            return new ResponseEntity(accessRightsList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
