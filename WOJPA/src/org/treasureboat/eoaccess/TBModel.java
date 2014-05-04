package org.treasureboat.eoaccess;

import java.util.List;

public abstract class TBModel {

	public static enum TransactionType {
		RESOURCE_LOCAL
	}

	private String name;
	private TransactionType transactionType;

	protected List<TBEntity> entities;

	public TBModel(String name) {
		this(name, TransactionType.RESOURCE_LOCAL);
	}

	public TBModel(String name, TransactionType transactionType) {
		this.name = name;
		this.transactionType = transactionType;
	}

	public String getName() {
		return name;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

}
