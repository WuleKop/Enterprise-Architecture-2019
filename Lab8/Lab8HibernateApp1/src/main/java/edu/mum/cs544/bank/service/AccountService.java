package edu.mum.cs544.bank.service;

import edu.mum.cs544.bank.dao.AccountDAO;
import edu.mum.cs544.bank.dao.IAccountDAO;
import edu.mum.cs544.bank.dao.JPAAcountDAO;
import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.Customer;
import edu.mum.cs544.bank.logging.ILogger;
import edu.mum.cs544.bank.logging.Logger;
import edu.mum.cs544.bank.util.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collection;


public class AccountService implements IAccountService {
    private IAccountDAO jpaAccountDAO;
    private ICurrencyConverter currencyConverter;
    private ILogger logger;
    private EntityManagerFactory entityManagerFactory;

    public AccountService() {
        jpaAccountDAO = new JPAAcountDAO();
        currencyConverter = new CurrencyConverter();
        logger = new Logger();
    }

    public Account createAccount(long accountNumber, String customerName) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        jpaAccountDAO.saveAccount(account);
        logger.log("createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
        em.getTransaction().commit();
        em.close();
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = jpaAccountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        jpaAccountDAO.updateAccount(account);
        logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        em.getTransaction().commit();
        em.close();
    }

    public Account getAccount(long accountNumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = jpaAccountDAO.loadAccount(accountNumber);
        em.getTransaction().commit();
        em.close();
        return account;
    }

    public Collection<Account> getAllAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Collection<Account> accounts=jpaAccountDAO.getAccounts();
        em.getTransaction().commit();
        em.close();
        return accounts;
    }

    public void withdraw(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = jpaAccountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        jpaAccountDAO.updateAccount(account);
        logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        em.getTransaction().commit();
        em.close();
    }

    public void depositEuros(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = jpaAccountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        jpaAccountDAO.updateAccount(account);
        logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        em.getTransaction().commit();
        em.close();
    }

    public void withdrawEuros(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = jpaAccountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        jpaAccountDAO.updateAccount(account);
        logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        em.getTransaction().commit();
        em.close();
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account fromAccount = jpaAccountDAO.loadAccount(fromAccountNumber);
        Account toAccount = jpaAccountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        jpaAccountDAO.updateAccount(fromAccount);
        jpaAccountDAO.updateAccount(toAccount);
        logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= " + toAccountNumber + " , amount= " + amount + " , description= " + description);
        em.getTransaction().commit();
        em.close();
    }
}
