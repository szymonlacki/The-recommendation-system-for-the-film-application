package pl.example.netflix.springapp.dto;


import pl.example.netflix.model.AccesRight;

public class AccountDTO {
    private Long accountId;
    private String login;
    private String password;
    private String currentPassword;


    private AccesRight.AccessRightEnum accessRight;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public AccesRight.AccessRightEnum getAccessRight() { return accessRight; }


    public void setAccessRight(AccesRight.AccessRightEnum accessRight) { this.accessRight = accessRight; }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", currentPassword='" + currentPassword + '\'' +
                ", accessRight=" + accessRight +
                '}';
    }
}
