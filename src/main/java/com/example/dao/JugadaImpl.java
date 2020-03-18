package com.example.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.model.Transaction;

@Repository
public class JugadaImpl implements IJugada {
	
	private static Logger LOG = LoggerFactory.getLogger(JugadaImpl.class);
	
	public String saveTransaction(Transaction t) {
		LOG.info(t.toString());
		return t.toString();
	}
}
