package com.demo.ajax.servlet;

import com.demo.ajax.dao.Dao;
import com.demo.ajax.pojo.Table;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(name = "ReadDao", urlPatterns = {"/read"})
public class ReadDao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Table table = new Table();
        Dao dao = new Dao();
        String[] datas = null;
        request.setCharacterEncoding("utf-8");
        String beginOfReadRange = request.getParameter("beginOfReadRange");
        String endOfReadRange = request.getParameter("endOfReadRange");
        int beginCount, endCount;
        if (beginOfReadRange != null && !beginOfReadRange.equals("") && endOfReadRange != null && !endOfReadRange.equals("")) {
            beginCount = Integer.parseInt(beginOfReadRange);
            endCount = Integer.parseInt(endOfReadRange);
            if (beginCount > endCount) {
                beginCount = 1;
                endCount = 9;
            }
        } else {
            beginCount = 1;
            endCount = 9;
        }
        try {
            datas = dao.read(beginCount, endCount);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String str = Arrays.toString(datas);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(str.substring(1, str.length() - 1));
        pw.flush();
        pw.close();
    }
}
