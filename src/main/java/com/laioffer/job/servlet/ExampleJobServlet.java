package com.laioffer.job.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.job.entity.ExampleCoordinates;
import com.laioffer.job.entity.ExampleJob;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ExampleJobServlet", urlPatterns = {"/example_job"})
public class ExampleJobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().print("This is the example job servlet");
        String keyword = request.getParameter("keyword");
        String remote = request.getParameter("remote");//what can be taken as parameters?

        System.out.println("Keyword is: " + keyword);
        System.out.println("Remote is: " + remote);

        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        //DB
        //Jackson turned the objects into JSON strings.
        //It can also turn JSON strings into model objects.
        ExampleCoordinates coordinates = new ExampleCoordinates(37.485130, -122.148316);
        ExampleJob job = new ExampleJob("Software Engineer", 123456, "Aug 1, 2020", false, coordinates);
        String jsonResponse=mapper.writeValueAsString(job);
        System.out.println(jsonResponse);
        response.getWriter().print(mapper.writeValueAsString(job));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //user write data to the server
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String title = jsonRequest.getString("title");
        int salary = jsonRequest.getInt("salary");
        String starting=jsonRequest.getString("starting");
        boolean remote=jsonRequest.getBoolean("remote");
        double latitude=jsonRequest.getDouble("latitude");
        double longitude=jsonRequest.getDouble("longitude");
        ExampleCoordinates coordinates=new ExampleCoordinates(latitude,longitude);

        // DB

        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }
}
