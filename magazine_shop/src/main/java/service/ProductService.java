package service;

import java.util.Map;

import abstractInterface.AbstractCRUD;
import domain.Product;

public interface ProductService extends AbstractCRUD<Product>{

	public Map<Integer, Product> readAllMap();
}
