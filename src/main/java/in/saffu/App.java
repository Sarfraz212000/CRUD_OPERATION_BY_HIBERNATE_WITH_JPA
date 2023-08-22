package in.saffu;

import in.saffu.dao.ProductDao;
import in.saffu.dao.impl.ProductDaoImpl;
import in.saffu.entity.ProductEntity;

public class App {
	public static void main(String[] args) {
		ProductDao dao = new ProductDaoImpl();

		ProductEntity p = new ProductEntity();

		// saving data in database
		
		p.setProductName("LEPTOP");
		p.setProduPrice(35000.00);
		p.setProductInStock(15);
		p.setProductAvilable(true);
		p.setProductDescription("HP BRAND LEPTOP");
		dao.saveProduct(p);

		// updating data in database

		/*ProductEntity entity = dao.updateProductPriceAndStockById(1, 40000.00, 10);
		System.out.println(entity);

		// fetching data from the data base

		ProductEntity product = dao.fetchProduct(1);
		System.out.println(product);

		// deleting data from the database

		dao.productDeleteById(2);*/

	}
}
