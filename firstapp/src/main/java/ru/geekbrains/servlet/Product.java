package ru.geekbrains.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "Product", urlPatterns = "/product.html")
public class Product extends HttpServlet {
    int id;
    String title;
    String cost;
    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");


        title = req.getParameter("title");
        cost = req.getParameter("cost");

          for (id=1; id <=10; id++) {

              double randomCost = Integer.parseInt (cost);
              randomCost = (randomCost * Math.random());
int intRandomCost = (int) randomCost;
              out.println("<html><body><h1>" + "ID " + id + " product " + title + " cost " + intRandomCost + "</h1></body></html>");
      }
        out.close();
    }
}
