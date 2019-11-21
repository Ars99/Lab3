package Servlets;

import DAO.DAOhash;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Cookie[] cookies = request.getCookies();
        DAOhash daohash = new DAOhash();

        if(!(cookies == null)){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("sessionId") && daohash.isContainHash(cookie.getValue())){
                   request.getRequestDispatcher("users.jsp").forward(request,response);
                }
            }
        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
