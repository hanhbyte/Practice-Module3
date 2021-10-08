package service;

import java.util.List;
import model.Product;

public interface IProductService {
List<Product> findAllProduct();
void saveProduct(String name, double price, int quantity, String color, String category);
void updateProduct(int id, String name, double price, int quntity, String color, String catgory);
void deleteProduct(int id);
Product findProductById(int id);
List<Product> findProductByName(String name);
}
