package in.saffu.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import in.saffu.dao.ProductDao;
import in.saffu.entity.ProductEntity;

public class ProductDaoImpl implements ProductDao {
	
	private EntityManagerFactory factory;
	public ProductDaoImpl() {
	    factory= Persistence.createEntityManagerFactory("test");
	}
	

	@Override
	public ProductEntity saveProduct(ProductEntity entity) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(entity);
			transaction.commit();
			System.out.println("data inserted into table successfully");
			
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("error in inserting data");
		}
		finally {
			entityManager.close();
		}
		
		return entity;
	}

	@Override
	public ProductEntity fetchProduct(Integer pId) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity productEntity = entityManager.find(ProductEntity.class, pId);
		
		entityManager.close();
		
		return productEntity;
	}

	@Override
	public ProductEntity updateProductPriceAndStockById(Integer pId, Double productPrice, Integer productInStock) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity productEntity = entityManager.find(ProductEntity.class, pId);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		productEntity.setProduPrice(productPrice);
		productEntity.setProductInStock(productInStock);
		tx.commit();
		entityManager.close();
		return productEntity;
	}

	@Override
	public void productDeleteById(Integer Pid) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity productEntity = entityManager.find(ProductEntity.class, Pid);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(productEntity);
		tx.commit();
		entityManager.close();
		
		
	}

}
