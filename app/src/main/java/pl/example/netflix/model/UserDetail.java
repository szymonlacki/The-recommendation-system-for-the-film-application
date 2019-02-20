package pl.example.netflix.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_DETAIL_ID")
    private Long userDetailId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "AGE")
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
    private Account account;

    public UserDetail(String name, String email, String age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }



    public UserDetail() {
    }

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



    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

   
}
