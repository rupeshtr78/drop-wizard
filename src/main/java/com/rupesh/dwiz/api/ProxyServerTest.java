package com.rupesh.dwiz.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class ProxyServerTest  {

    @NotEmpty
    private String proxyPrefix;

    @NotEmpty
    private String proxyTo;

    public void setProxyPrefix(String proxyPrefix) {
        this.proxyPrefix = proxyPrefix;
    }

    public void setProxyTo(String proxyTo) {
        this.proxyTo = proxyTo;
    }

    @JsonProperty
    public String getProxyPrefix() {
        return this.proxyPrefix;
    }

    @JsonProperty
    public String getProxyTo() {
        return this.proxyTo;
    }
}
