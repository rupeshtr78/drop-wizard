package com.rupesh.dwiz.resources;

import com.rupesh.dwiz.api.SayAge;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path( "/age" )
@Produces(MediaType.APPLICATION_JSON)
public class DwizSayAge {
    public final Integer age;
    public final String ageString;


    public DwizSayAge(Integer age, String ageString) {
        this.age = age;
        this.ageString = ageString;
    }

    @GET
    public SayAge sayAge(@QueryParam( "age" )Optional<Integer> age) {
        final String ageStr = String.format( ageString , age.orElse( 1978 ) );
        return new SayAge(age , ageStr);
    }


}


