package com.rupesh.dwiz.resources;

import com.fasterxml.jackson.core.JsonParser;
import com.rupesh.dwiz.api.Employee;
import com.rupesh.dwiz.core.RequestWrapper;
import com.rupesh.dwiz.db.EmployeeDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.StringTokenizer;

@Path( "/employee2" )
@Produces (MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource2 {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeResource2.class);


    @POST
    @Path( "/redirect" )
    public Response post(@Context ServletRequest request, @Context ServletResponse response, Employee employee)
            throws IOException {


        RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) request);
        String requestWrapperBody = requestWrapper.getBody();
        System.out.println(requestWrapperBody);

        return  Response.status( 600 , "Redirected Request 9090" ).build();

    }


}
