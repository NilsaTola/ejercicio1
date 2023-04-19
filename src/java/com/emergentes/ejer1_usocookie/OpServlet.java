package com.emergentes.ejer1_usocookie;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "OpServlet", urlPatterns = {"/OpServlet"})
public class OpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje="Visitado";
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null)
        {
            for(Cookie C : cookies){
                if(C.getName().equals("visita")){
                    request.getRequestDispatcher("salida2.jsp").forward(request, response);
                }else{
                    Cookie Caux = new Cookie("visita",mensaje);
                    Caux.setMaxAge(10);
                    response.addCookie(Caux);
                    request.getRequestDispatcher("salida.jsp").forward(request, response);
                }
            }
        }else{
            response.sendRedirect("index.jsp");
        }

    }
}