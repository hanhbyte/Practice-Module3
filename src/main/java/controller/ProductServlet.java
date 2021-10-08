package controller;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import model.Product;
import service.ProductService;

@WebServlet(name = "ProductServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {

  private ProductService productService = new ProductService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "newProduct":
        formCreatProduct(request, response);
        break;
      case "editProduct":
        formEditProduct(request, response);
        break;
      case "deleteProduct":
        deleteProduct(request, response);
        break;
      case "searchProduct":
        formSearchProduct(request, response);
        break;
      default:
        showListProduct(request, response);
        break;
    }
  }

  private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
    List<Product> listProduct = productService.findAllProduct();
    request.setAttribute("listProduct", listProduct);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListProduct.jsp");
    try {
      requestDispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void formSearchProduct(HttpServletRequest request, HttpServletResponse response) {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/search.jsp");
    try {
      requestDispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void SearchProduct(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    List<Product> listProduct = productService.findProductByName(name);
    request.setAttribute("listProduct", listProduct);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/ListProduct.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    productService.deleteProduct(id);
    try {
      response.sendRedirect("/deleteProduct.jsp");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void formEditProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = productService.findProductById(id);
    request.setAttribute("product", product);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/editProduct.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void formCreatProduct(HttpServletRequest request, HttpServletResponse response) {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/createProduct.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "newProduct":
        createProduct(request, response);
        break;
      case "editProduct":
        editProduct(request, response);
        break;
      case "searchProduct":
        SearchProduct(request, response);
        break;
      default:
        break;
    }
  }

  private void editProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    double price = Double.parseDouble(request.getParameter("price"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String color = request.getParameter("color");
    String category = request.getParameter("category");
    productService.updateProduct(id, name, price, quantity, color, category);
    try {
      response.sendRedirect("/products");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void createProduct(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    double price = Double.parseDouble(request.getParameter("price"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));
    String color = request.getParameter("color");
    String category = request.getParameter("category");
    productService.saveProduct(name, price, quantity, color, category);
    try {
      response.sendRedirect("/products");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
