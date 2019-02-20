package pl.example.netflix.springapp.dto;


public class UserDetailDTO {
    private Long userDetailId;
    private String name;
    private String email;
    private String age;

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    private AccountDTO account;

    public Long getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Long userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "UserDetailDTO{" +
                "userDetailId=" + userDetailId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", account=" + account +
                '}';
    }
}
