package service;

import config.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductService implements IProductService {

  Connection connection = ConnectionDB.getConnection();
  public static final String SELECT_ALL_PRODUCT = "select *from product; ";
  public static final String INSERT_INTO_PRODUCT =
      "insert into product" + "(nameProduct, price, quantity,color,category) VALUES"
          + " (?, ?, ?,?,?);";
  public static final String UPDATE_PRODUCT = "update product set nameProduct  = ?,price= ?, quantity =?, color = ?, category = ?  where id = ?;";
  public static final String DELETE_PRODUCT_BYID = "delete from product where id = ?;";
  public static final String SELECT_PRODUCT_BYID = "select nameProduct,price, quantity,color,category from product where id =?";
  public static final String SELECT_PRODUCT_BYNAME = "select id,price, quantity,color,category where nameProduct = ? ";

  @Override
  public List<Product> findAllProduct() {
    List<Product> list = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        int quantity = resultSet.getInt("quantity");
        String color = resultSet.getString("color");
        String category = resultSet.getString("category");
        list.add(new Product(id, name, price, quantity, color, category));
      }
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void saveProduct(String name, double price, int quantity, String color, String category) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);
      preparedStatement.setString(1, name);
      preparedStatement.setDouble(2, price);
      preparedStatement.setInt(3, quantity);
      preparedStatement.setString(4, color);
      preparedStatement.setString(5, category);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateProduct(int id, String name, double price, int quantity, String color,
      String category) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
      preparedStatement.setString(1, name);
      preparedStatement.setDouble(2, price);
      preparedStatement.setInt(3, quantity);
      preparedStatement.setString(4, color);
      preparedStatement.setString(5, category);
      preparedStatement.setInt(6, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteProduct(int id) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BYID);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Product findProductById(int id) {
    Product product = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BYID);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        int quantity = resultSet.getInt("quantity");
        String color = resultSet.getString("color");
        String category = resultSet.getString("category");
        product = new Product(id, name, price, quantity, color, category);
      }
      return product;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Product> findProductByName(String name) {
    List<Product> list = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BYNAME);
      preparedStatement.setString(1, name);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        int id = resultSet.getInt("id");
        double price = resultSet.getDouble("price");
        int quantity = resultSet.getInt("quantity");
        String color = resultSet.getString("color");
        String category = resultSet.getString("category");
        list.add(new Product(id, name, price, quantity, color, category));
      }
      return  list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return  null;
  }
}
