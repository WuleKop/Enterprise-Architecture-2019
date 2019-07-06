package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.util.EntityManagerHelper;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JPAAcountDAO implements IAccountDAO {
    private EntityManagerFactory entityManagerFactory;
    @Override
    public void saveAccount(Account account) {
        EntityManager em2= EntityManagerHelper.getCurrent();
        em2.persist(account);

    }

    @Override
    public void updateAccount(Account account) {
        EntityManager em2= EntityManagerHelper.getCurrent();
        em2.merge(account);

    }

    @Override
    public Account loadAccount(long accountnumber) {

        EntityManager em2= EntityManagerHelper.getCurrent();
        EntityGraph<Account> graph=em2.createEntityGraph(Account.class);
        graph.addAttributeNodes("customer");
        graph.addAttributeNodes("entryList");
        Map<String,Object> properties=new HashMap<>();
        properties.put("javax.persistence.fetchgraph",graph);
        Account account=em2.find(Account.class,accountnumber,properties);
        return account;
    }

    @Override
    public Collection<Account> getAccounts() {
        EntityManager em2= EntityManagerHelper.getCurrent();
        TypedQuery<Account> query=em2.createQuery("select distinct a from Account a join fetch a.entryList",Account.class);
        Collection<Account> accounts=query.getResultList();
        return accounts;
    }
}
