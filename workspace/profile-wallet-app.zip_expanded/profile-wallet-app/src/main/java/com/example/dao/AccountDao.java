package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

}
