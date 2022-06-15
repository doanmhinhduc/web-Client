package com.example.webclient.controller;

import com.example.webclient.entity.Product;
import com.example.webclient.retrofit.RetrofitService;
import com.example.webclient.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetProduct extends HttpServlet {
    ProductService productService;

    public GetProduct(){
        productService = RetrofitService.createService(ProductService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> employees = productService.getProduct().execute().body();
        req.setAttribute("employees",employees);
        req.getRequestDispatcher("/employees/list.jsp").forward(req,resp);
    }
}
