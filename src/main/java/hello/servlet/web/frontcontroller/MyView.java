package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

     public void render(Map<String,Object> paramMap, HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
         modelToRequestAttribute(paramMap, request);
         RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
         dispatcher.forward(request,response);
     }

    private void modelToRequestAttribute(Map<String, Object> paramMap, HttpServletRequest request) {
        paramMap.forEach((key, value)-> request.setAttribute(key , value));
    }


}
