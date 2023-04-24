package com.rupesh.dwiz.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {
    public long id;

    public String content;

    public Saying() {
       //TODO
    }

    public Saying(long id , String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId(){
        return id;
    }

    @JsonProperty
    public String getContent(){
        return content;
    }

}
