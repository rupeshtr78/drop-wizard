package com.rupesh.dwiz.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rupesh.dwiz.api.Employee;
import com.rupesh.dwiz.api.NotaryValidateResponse;
import io.swagger.v3.oas.annotations.Parameter;
import com.rupesh.dwiz.db.EmployeeDb;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.*;

@PermitAll
@Path( "/notary" )
@Consumes({MediaType.APPLICATION_JSON, "text/yaml", MediaType.WILDCARD})
@Produces(MediaType.APPLICATION_JSON)
public class NotaryValidateResource {

    private static final Logger logger = LoggerFactory.getLogger(NotaryValidateResource.class);

    @GET
    @Path( "/notary-test" )
    public Response getEmployeeId() {
        System.out.println("Notary get");
        return Response.status(200,"Get Success").build();

    }

    @POST
    @Path("/actor-assumablity-check")
    public NotaryValidateResponse validateNotaryIdentity(ValidateRequestBody2 validateRequestBody){
        NotaryValidateResponse response = new NotaryValidateResponse();
        response.setAssumable(Boolean.TRUE);

        System.out.println(validateRequestBody.actorAprn);
        System.out.println(validateRequestBody.audience);
        System.out.println(validateRequestBody.assumeAprn);
        System.out.println(validateRequestBody.claims);

//        HashMap<String,String> requestClaims= validateRequestBody.claims;
//        String notarySparkApplication = requestClaims.getOrDefault("sparkApplicationId","None");
//        String notarySparkApplication;

        if (validateRequestBody.getClaims() !=null) {
            HashMap<String,String> requestClaims= validateRequestBody.getClaims();
            String notarySparkApplication = requestClaims.getOrDefault("sparkApplicationId","None");

            response.setClaims(requestClaims);
            }



        return response;
    }

    public static class ValidateRequestBody {

//      actorAprn: required, aprn of the actor identity
        @JsonProperty("actorAprn")
        public String actorAprn;

//      assumeAprn: aprn of the assume identity
        @JsonProperty("assumeAprn")
        public String assumeAprn;

//      audience: required, list of audience aprn requested
        @JsonProperty("audience")
        public List<String> audience;

//      sourceIp: IP address of the original assume request
        @JsonProperty("sourceIp")
        public List<String> sourceIp;

//      claims: optional, list of custom claims requested
        @JsonProperty("claims")
        public HashMap<String,String> claims;


    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ValidateRequestBody2 {

        public String getActorAprn() {
            return actorAprn;
        }

        public void setActorAprn(String actorAprn) {
            this.actorAprn = actorAprn;
        }

        public String getAssumeAprn() {
            return assumeAprn;
        }

        public void setAssumeAprn(String assumeAprn) {
            this.assumeAprn = assumeAprn;
        }

        public List<String> getAudience() {
            return audience;
        }

        public void setAudience(List<String> audience) {
            this.audience = audience;
        }

        public List<String> getSourceIp() {
            return sourceIp;
        }

        public void setSourceIp(List<String> sourceIp) {
            this.sourceIp = sourceIp;
        }

        public HashMap<String, String> getClaims() {
            return claims;
        }

        public void setClaims(HashMap<String, String> claims) {
            this.claims = claims;
        }

        //      actorAprn: required, aprn of the actor identity
        public String actorAprn;

        //      assumeAprn: aprn of the assume identity
        public String assumeAprn;
        //      audience: required, list of audience aprn requested
        public List<String> audience;
        //      sourceIp: IP address of the original assume request
        public List<String> sourceIp;
        //      claims: optional, list of custom claims requested
        public HashMap<String,String> claims;


    }


}
