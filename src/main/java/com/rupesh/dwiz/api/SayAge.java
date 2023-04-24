package com.rupesh.dwiz.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;


public class SayAge {

    public Optional <Integer> age;
    public String ageString;

    public SayAge(){

    }

    public SayAge(Optional<Integer> age, String ageString) {
        this.age = age;
        this.ageString = ageString;
    }


    @JsonProperty
    public Optional <Integer> getAge() {
        return age;
    }

    @JsonProperty
    public String getAgeString() {
         return ageString;
    }


}
