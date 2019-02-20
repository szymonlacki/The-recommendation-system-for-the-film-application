package pl.example.netflix.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.example.netflix.common.HashUtils;
import pl.example.netflix.model.*;
import pl.example.netflix.springapp.dao.AccountDao;
import pl.example.netflix.springapp.dao.FavoriteListDao;
import pl.example.netflix.springapp.dao.UserDetailDao;
import pl.example.netflix.springapp.dto.AccountDTO;
import pl.example.netflix.springapp.dto.ActorDTO;
import pl.example.netflix.springapp.dto.UserDetailDTO;
import pl.example.netflix.springapp.mapper.ActorMapper;
import pl.example.netflix.springapp.mapper.FavoriteListMapper;
import pl.example.netflix.springapp.mapper.MovieMapper;
import pl.example.netflix.springapp.mapper.UserMapper;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final AccountDao accountDao;
    private final UserDetailDao userDetailDao;
    private final FavoriteListDao favoriteListDao;

    @Autowired
    public UserService(AccountDao accountDao, UserDetailDao userDetailDao, FavoriteListDao favoriteListDao) {
        this.accountDao = accountDao;
        this.userDetailDao = userDetailDao;
        this.favoriteListDao = favoriteListDao;
    }

       public List<UserDetailDTO> getUsers() throws Exception {
        Iterable<UserDetail> UserDetailIterable = this.userDetailDao.findAll();
        List<UserDetailDTO> UserDetailDTOList = new ArrayList<>();

        for(UserDetail tmpUserDetail : UserDetailIterable){
            UserDetailDTOList.add(UserMapper.toUserDTO(tmpUserDetail));
        }

        return UserDetailDTOList;
    }


    public UserDetailDTO registration(UserDetailDTO userDetailDTO) throws Exception {
        //Domyślnie prawa dostępu będą użytkownika
        userDetailDTO.getAccount().setAccessRight(AccesRight.AccessRightEnum.CUSTOMER);
        validateAddAccount(userDetailDTO);//walidacja
        UserDetail userDetail = userDetailDao.save(UserMapper.toUserDetail(userDetailDTO));
        AccountDTO accountDTO = userDetailDTO.getAccount();
        accountDTO.setPassword(HashUtils.generateHash(accountDTO.getPassword(), 10));
        Account account = accountDao.save(UserMapper.toAccount(accountDTO, userDetail));

        /*Tworze pustą listę zainicjowaną użytkownikiem, od tego momentu użytkownik posiada swoją własną listę
        ulubionych filmów*/
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setAccount(account);
        this.favoriteListDao.save(favoriteList);
        return UserMapper.toUserDTO(account);
    }

    public UserDetailDTO login(AccountDTO accountDTO) throws Exception {
        Optional<Account> optionalAccount = findAccountByLogin(accountDTO);
        Account modelAccount;

        if (optionalAccount.isPresent()) {
            modelAccount = optionalAccount.get();
            System.out.println("Zalogowano poprawnie");
        }
        else {
            throw new Exception("Niepoprawny login lub hasło.");
        }

        if (HashUtils.verifyPassword(accountDTO.getPassword(), modelAccount.getPassword())) {
            return UserMapper.toUserDTO(modelAccount);
        } else {
            throw new Exception("Niepoprawny login lub hasło.");
        }
    }

    public void updateUserAccount(Long userDetailId, UserDetailDTO userDetailDTO) throws Exception {
        validateUpdatedAccount(userDetailDTO);
        userDetailDTO.setUserDetailId(userDetailId);
        AccountDTO accountDTO = userDetailDTO.getAccount();
        accountDTO.setPassword(HashUtils.generateHash(accountDTO.getPassword(), 10));
        UserDetail userDetail = UserMapper.toUserDetail(userDetailDTO);
        Account account = UserMapper.toAccount(accountDTO,userDetail);
             this.accountDao.save(account);
             this.userDetailDao.save(userDetail);
    }

    public void deleteUserAccount(Long userDetailId) {
        userDetailDao.deleteById(userDetailId);
    }

    private void validateAddAccount(UserDetailDTO userDetailDTO) throws Exception {
        if (findAccountByLogin(userDetailDTO.getAccount()).isPresent()) {
            throw new Exception("Konto o podanym loginie już istnieje.");
        }

        if (findUserDetailByEmail(userDetailDTO).isPresent()) {
            throw new Exception("Istnieje już konto przypisane do podanego adresu email.");
        }
    }

    private void validateUpdatedAccount(UserDetailDTO userDetailDTO) throws Exception {
        Account modelAccount = findAccountById(userDetailDTO.getAccount().getAccountId());

        if (!HashUtils.verifyPassword(userDetailDTO.getAccount().getCurrentPassword(), modelAccount.getPassword())) {
            throw new Exception("Niepoprawe obecne hasło.");
        }

        Optional<Account> accountFoundedByLogin = findAccountByLogin(userDetailDTO.getAccount());
        if (accountFoundedByLogin.isPresent() && accountFoundedByLogin.get().getAccountId() != userDetailDTO.getAccount().getAccountId()) {
            throw new Exception("Konto o podanym loginie już istnieje.");
        }

        Optional<UserDetail> accountFoundedByEmail = findUserDetailByEmail(userDetailDTO);
        if (accountFoundedByEmail.isPresent() && accountFoundedByEmail.get().getUserDetailId() != userDetailDTO.getUserDetailId()) {
            throw new Exception("Istnieje już konto przypisane do podanego adresu email.");
        }
    }

    public Account findAccountById(Long accountId) throws Exception {
        Optional<Account> account = accountDao.findById(accountId);
        if (account.get() == null) {
            throw new Exception(Account.class.getSimpleName());
        }

        return account.get();
    }


    private Optional<Account> findAccountByLogin(AccountDTO accountDTO) throws Exception {
        return accountDao.findAccountByLogin(accountDTO.getLogin());
    }

    private Optional<UserDetail> findUserDetailByEmail(UserDetailDTO userDetailDTO) throws Exception {
        return userDetailDao.findUserDetailsByEmail(userDetailDTO.getEmail());
    }

    public void changeAccessRights(Long userDetailId, UserDetailDTO userDetailDTO) throws Exception {

        AccountDTO accountDTO = userDetailDTO.getAccount();
        UserDetail userDetail = UserMapper.toUserDetail(userDetailDTO);
        Account account = UserMapper.toAccount(accountDTO,userDetail);
        this.accountDao.save(account);

    }

}