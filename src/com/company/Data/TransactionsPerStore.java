package com.company.Data;

public class TransactionsPerStore {
	private int storeId;
	private double ratioCard;
	private double ratioCash;
	
	public TransactionsPerStore(int storeId,double ratioCard,double ratioCash) {
		this.storeId=storeId;
		this.ratioCard=ratioCard;
		this.ratioCash=ratioCash;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public double getratioCard() {
		return ratioCard;
	}

	public void setratioCard(double ratioCard) {
		this.ratioCard = ratioCard;
	}

	public double getratioCash() {
		return ratioCash;
	}

	public void setratioCash(double ratioCash) {
		this.ratioCash = ratioCash;
	}
	

}
