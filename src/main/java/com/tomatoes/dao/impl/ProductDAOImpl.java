package com.tomatoes.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomatoes.dao.ProductDAO;
import com.tomatoes.model.Products;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Products product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
		
	}

	@Override
	public Products getProductByID(String productId) {
		Session session = sessionFactory.getCurrentSession();
		Products product = (Products) session.get(Products.class, productId);
		session.flush();
		return product;
	}

	@Override
	public List<Products> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Products");
		List<Products> prodList = q.list();
		session.flush();
		return prodList;
	}

	@Override
	public void deleteProduct(String productId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductByID(productId));
		session.flush();
	}

	@Override
	public void editProduct(Products product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
		
		
	}

}
