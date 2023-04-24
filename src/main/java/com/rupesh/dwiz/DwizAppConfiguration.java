package com.rupesh.dwiz;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;

public class DwizAppConfiguration extends Configuration {
    // TODO: implement service configuration


    private String applicationContextPath;

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    private Integer age = 78;

    @NotEmpty
    private String ageString;

    public String getApplicationContextPath() {
        return applicationContextPath;
    }

    public void setApplicationContextPath(String applicationContextPath) {
        this.applicationContextPath = applicationContextPath;
    }

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;

    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;

    }

    @JsonProperty
    public void setDefaultName(String defaultName){
        this.defaultName = defaultName;
    }

    @JsonProperty
    public Integer getAge(){
        return age;
    }

    @JsonProperty
    public void setAge(Integer age){
        this.age = age;
    }


    @JsonProperty
    public String getAgeString() {
        return ageString;
    }

    @JsonProperty
    public void setAgeString(String ageString) {
        this.ageString = ageString;
    }


    public String getProxyPrefix() {
        return proxyPrefix;
    }

    public String getProxyTo() {
        return proxyTo;
    }

    private String proxyPrefix = "/proxy";


    private String proxyTo;

    public void setProxyPrefix(String proxyPrefix) {
        this.proxyPrefix = proxyPrefix;
    }

    public void setProxyTo(String proxyTo) {
        this.proxyTo = proxyTo;
    }

}
