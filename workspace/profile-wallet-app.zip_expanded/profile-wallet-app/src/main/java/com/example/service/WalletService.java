package com.example.service;

public interface WalletService {
	public boolean addAmountToWallet(int walletId, int accountNumber, double amount);
	public boolean sendMoneyFromWallet(int sourceWalletId, int destinationWalletId, double amount);
}
