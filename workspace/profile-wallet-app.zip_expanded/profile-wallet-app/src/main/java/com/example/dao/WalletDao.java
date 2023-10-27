package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer>{

}
