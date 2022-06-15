package com.example.webclient.controller;

import com.example.webclient.entity.Product;
import com.example.webclient.retrofit.RetrofitService;
import com.example.webclient.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProduct extends HttpServlet {
    private static Product obj;

    private final ProductService productService;

    public CreateProduct() {
        productService = RetrofitService.createService(ProductService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        obj = new Product(1,"Product new",2,1);
        req.setAttribute("product", obj);
        req.getRequestDispatcher("/product/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        obj.setName(req.getParameter("name"));
        obj.setPrice(new Double(req.getParameter("price")));
        obj.setQuantity(Integer.parseInt(req.getParameter("price")));

        productService.addProduct(obj).execute();
        resp.sendRedirect("/product");
    }
}
