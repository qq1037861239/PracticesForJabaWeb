package com.demo.ajax.servlet;

import com.demo.ajax.dao.Dao;
import com.demo.ajax.pojo.Table;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "WriteDao",  urlPatterns = {"/write"})
public class WriteDao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Table table = new Table();
        Dao dao = new Dao();
        String[] datas = request.getParameter("datas").split(",");

        try {
            for (String data: datas) {
                dao.write(data);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
