package pl.example.netflix.springapp.mapper;

import pl.example.netflix.model.AccesRight;
import pl.example.netflix.model.Account;
import pl.example.netflix.model.UserDetail;
import pl.example.netflix.springapp.dto.AccountDTO;
import pl.example.netflix.springapp.dto.UserDetailDTO;

public class UserMapper {

    @Deprecated
    public static UserDetailDTO toUserDTO(UserDetail userDetail) {
        UserDetailDTO userDTO = new UserDetailDTO();
        userDTO.setUserDetailId(userDetail.getUserDetailId());
        userDTO.setName(userDetail.getName());
        userDTO.setEmail(userDetail.getEmail());
        userDTO.setAge(userDetail.getAge());
        userDTO.setAccount(toAccountDTO(userDetail.getAccount()));
        return userDTO;
    }

    public static UserDetailDTO toUserDTO(Account account) {
        UserDetailDTO userDTO = new UserDetailDTO();
        userDTO.setUserDetailId(account.getUserDetail().getUserDetailId());
        userDTO.setName(account.getUserDetail().getName());
        userDTO.setEmail(account.getUserDetail().getEmail());
        userDTO.setAge(account.getUserDetail().getAge());
        userDTO.setAccount(toAccountDTO(account));
        return userDTO;
    }

    private static AccountDTO toAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(account.getAccountId());
        accountDTO.setLogin(account.getLogin());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setAccessRight(AccesRight.AccessRightEnum.getAccessRight(account.getAccessRight()));
        return accountDTO;
    }

    public static UserDetail toUserDetail(UserDetailDTO userDetailDTO) {
        UserDetail userDetail = new UserDetail();
        userDetail.setUserDetailId(userDetailDTO.getUserDetailId());
        userDetail.setName(userDetailDTO.getName());
        userDetail.setEmail(userDetailDTO.getEmail());
        userDetail.setAge(userDetailDTO.getAge());
        return userDetail;
    }

    public static Account toAccount(AccountDTO accountDTO, UserDetail userDetail) {
        Account account = new Account();
        account.setAccountId(accountDTO.getAccountId());
        account.setLogin(accountDTO.getLogin());
        account.setPassword(accountDTO.getPassword());
        account.setAccessRight(accountDTO.getAccessRight().getAccessRight());
        account.setUserDetail(userDetail);

        return account;
    }}