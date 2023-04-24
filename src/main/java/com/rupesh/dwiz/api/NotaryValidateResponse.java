package com.rupesh.dwiz.api;

import java.util.HashMap;
import java.util.List;

public class NotaryValidateResponse {

    public Boolean assumable;

    public List<String> audience;

    public HashMap<String,String> claims;


    public Boolean getAssumable() {
        return assumable;
    }

    public void setAssumable(Boolean assumable) {
        this.assumable = assumable;
    }

    public List<String> getAudience() {
        return audience;
    }

    public void setAudience(List<String> audience) {
        this.audience = audience;
    }

    public HashMap<String, String> getClaims() {
        return claims;
    }

    public void setClaims(HashMap<String, String> claims) {
        this.claims = claims;
    }
}
