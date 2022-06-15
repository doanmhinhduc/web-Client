package com.example.webclient.controller;

import com.example.webclient.entity.Product;
import com.example.webclient.retrofit.RetrofitService;
import com.example.webclient.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProduct extends HttpServlet {
    private static Product obj;

    private final ProductService productService;

    public UpdateProduct() {
        productService = RetrofitService.createService(ProductService.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        obj = productService.getProductDetail(id).execute().body();
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            req.setAttribute("employee", obj);
            req.getRequestDispatcher("/employee/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        obj.setName(req.getParameter("name"));
        obj.setPrice(new Double(req.getParameter("price")));
        obj.setQuantity(Integer.parseInt(req.getParameter("quantity")));

        productService.updateProduct(id,obj).execute();
        resp.sendRedirect("/employees");
    }
}
