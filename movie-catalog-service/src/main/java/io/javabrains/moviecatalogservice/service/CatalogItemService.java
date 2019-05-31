package io.javabrains.moviecatalogservice.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.moviecatalogservice.dao.CatalogItemDao;
import io.javabrains.moviecatalogservice.models.CatalogItem;

@Service
public class CatalogItemService {

	@Autowired
	protected CatalogItemDao dao;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void saveCatalogItem(CatalogItem cI) {		
		dao.persist(cI);
		
	}
	
}
