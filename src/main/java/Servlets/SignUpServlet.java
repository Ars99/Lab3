package Servlets;

import DAO.DAOhash;
import DAO.DAOpassword;
import Entities.LoginHashEntity;
import Entities.LoginPasswordEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DAOpassword daoPass = new DAOpassword();
        DAOhash daoHash = new DAOhash();

        LoginPasswordEntity userPass = new LoginPasswordEntity(login, password);

        String hashOfSession = UUID.randomUUID().toString();

        LoginHashEntity userHash = new LoginHashEntity(login, hashOfSession);
        if (daoPass.isContain(login, password)){
            request.setAttribute("msg", "login or password is already used");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        else{
            daoHash.addUser(userHash);
            daoPass.addUser(userPass);
            Cookie cookie = new Cookie("sessionId", hashOfSession);
            response.addCookie(cookie);
            response.sendRedirect("http://localhost:8080/Lab3_3_war_exploded/users.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
