package pl.example.netflix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

public class AccesRight {
    public enum AccessRightEnum {
        CUSTOMER("Client"),
        ADMINISTRATOR("Admin");

        private String accessRight;

        private AccessRightEnum(String accessRight) {
            this.accessRight = accessRight;
        }

        @JsonCreator
        public static AccessRightEnum fromValue(String value) {
            return getAccessRight(value);
        }

        public void setAccessRight(String accessRight) {
            this.accessRight = accessRight;
        }

        @JsonValue
        public String toJson() {
            return getAccessRight();
        }

        public String getAccessRight() {
            return accessRight;
        }

        public static AccessRightEnum getAccessRight(String name) {
            for(AccessRightEnum current : AccessRightEnum.values()) {
                if(current.accessRight.equals(name)) {
                    return current;
                }
            }
            return null;
        }
    }

    public List<String> getAccessRights(){
        List<String> accessRightEnumList = new ArrayList<>();
        AccessRightEnum[] accessRightEnums = AccessRightEnum.values();
        for (AccessRightEnum accessRightEnum : accessRightEnums) {
            accessRightEnumList.add(accessRightEnum.getAccessRight());
        }
        return accessRightEnumList;
    }
}
