package in.saffu.dao;

import in.saffu.entity.ProductEntity;

public interface ProductDao {
	
	public ProductEntity saveProduct(ProductEntity entity);
	
	public  ProductEntity fetchProduct(Integer pId);
	
	public ProductEntity updateProductPriceAndStockById(Integer pId,Double productPrice,Integer productInStock );
	
	public void productDeleteById(Integer Pid);
	

}
