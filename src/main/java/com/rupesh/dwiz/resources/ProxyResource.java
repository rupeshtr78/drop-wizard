package com.rupesh.dwiz.resources;

import com.rupesh.dwiz.api.ProxyServerTest;
import org.eclipse.jetty.proxy.ProxyServlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.jetty.proxy.ProxyServlet;
@Path("/")
public class ProxyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "ok";
    }
}


