package Servlets;

import DAO.DAOhash;
import DAO.DAOpassword;
import Entities.LoginHashEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "/SignInServlet")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DAOhash daohash = new DAOhash();
        DAOpassword daopassword = new DAOpassword();

        if (daopassword.isContain(login, password)) {
            String hash = daohash.getHash(login);
            if (hash == null) {
                hash = UUID.randomUUID().toString();
                LoginHashEntity newuser = new LoginHashEntity(login, hash);
                daohash.addUser(newuser);
                Cookie cookie = new Cookie("sessionId", hash);
                response.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("sessionId", hash);
                response.addCookie(cookie);
            }
            request.getRequestDispatcher("users.jsp").forward(request,response);
        }
        else{
            request.setAttribute("msg", "Incorrect login or password");
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
