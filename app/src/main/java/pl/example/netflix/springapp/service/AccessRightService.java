package pl.example.netflix.springapp.service;

import org.springframework.stereotype.Service;
import pl.example.netflix.model.AccesRight;

import java.util.List;

@Service
public class AccessRightService {
    AccesRight accessRight = new AccesRight();

    public List<String> getAccessRights() {
        List<String> accessRightsList = accessRight.getAccessRights();
        return accessRightsList;
    }
}
