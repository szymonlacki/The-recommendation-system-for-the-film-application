package pl.example.netflix.springapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.example.netflix.model.Account;

import java.util.Optional;

@Repository
public interface AccountDao extends CrudRepository<Account,Long> {
    @Query("SELECT a FROM Account a WHERE a.login like ?1")
    Optional<Account> findAccountByLogin(@Param("login") String login);
}
