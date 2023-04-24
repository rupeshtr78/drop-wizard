package com.rupesh.dwiz.resources;

import com.rupesh.dwiz.api.Employee;
import com.rupesh.dwiz.db.EmployeeDb;


import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path( "/employee" )
@Produces (MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    @GET
    public Response getEmployees(){
        return Response.ok(EmployeeDb.getEmployeeList()).build();
    }

    @GET
    @Path( "/{id}" )
    public Response getEmployeeId(@PathParam( "id" ) Integer id) {
        Employee employee = EmployeeDb.getEmployee( id );
        if (employee != null )

            return Response.ok(employee).build();
        else
//            return Response.status( Response.Status.NOT_FOUND ).build();
            return Response.status( 400, "Not Found" ).build();
    }

   @PUT
   @Path("/{id}")
    public Response updateEmployee(@PathParam( "id" ) Integer empId ,
                                   @QueryParam( "overwrite" ) Optional<Boolean> overwrite ,
                                   Employee employee) throws URISyntaxException {
        Employee emp = EmployeeDb.getEmployee( empId );
        logger.info( String.format( "Employee: %s", emp) );

        if (emp != null) {
            if (overwrite.equals( Optional.of( true ) ) || overwrite.isEmpty() ) {
               employee.setEmployeeId( empId );
               EmployeeDb.updateEmployee( empId ,employee );
               return Response.status( Response.Status.OK ).entity( employee ).build();
           }else {
                return Response.status( 304 , "Not Modified" ).entity( employee ).build();
           }
       }else
           return Response.status( 400 , "Employee Not Found" ).build();


   }

    @POST
    public Response createEmployee(Employee employee) throws URISyntaxException {
        Employee emp = EmployeeDb.getEmployee( employee.getEmployeeId());

        if (emp == null) {
            EmployeeDb.updateEmployee( employee.getEmployeeId() , employee );
            System.out.println(Response.noContent().build());
            return Response.created( new URI( "/employee/" + employee.getEmployeeId() ) ).entity( employee ).build();
        }
        else
            return Response.status( 400 , "Employee Already Exists" ).build();


    }

    @DELETE
    @Path( "/{id}" )
    public Response deleteEmployee(@PathParam( "id" ) Integer empId) {
        Employee employee = EmployeeDb.getEmployee( empId );

        if ( employee != null) {
            EmployeeDb.removeEmployee( empId );
            return Response.ok(employee).tag( String.format( "Deleted Employye ID %s", employee.getEmployeeId()) ).build();

        }
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }



}
