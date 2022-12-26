package service.implement;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import dao.ProductDao;
import domain.Product;
import implement.ProductDaoImplement;
import service.ProductService;

public class ProductServiceImplement implements ProductService {

	private static Logger LOGGER = Logger.getLogger(ProductServiceImplement.class);
	private static ProductService productServiceImplement;
	private ProductDao productDao;

	private ProductServiceImplement() {

		try {
			productDao = new ProductDaoImplement();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error("Error - ProductServiceImplement - ", e);
		}
	}

	public static ProductService getProductService() {
		if (productServiceImplement == null) {
			productServiceImplement = new ProductServiceImplement();
		}
		return productServiceImplement;
	}

	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product product) {
		return productDao.update(product);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	@Override
	public Map<Integer, Product> readAllMap() {
		return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
	}

}
