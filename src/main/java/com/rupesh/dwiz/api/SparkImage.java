package com.rupesh.dwiz.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SparkImage {

    private List<SparkImage> sparkImages;
    private String name;
    private List<String> types;
    private String version;

    public List<SparkImage> getSparkImages() {
        return sparkImages;
    }

    public void setSparkImages(List<SparkImage> sparkImages) {
        this.sparkImages = sparkImages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Optional<SparkImage> resolveImage(String type, String version) {
        if (sparkImages == null || sparkImages.isEmpty()) {
            return Optional.empty();
        }
        return sparkImages.stream()
                .filter(
                        t ->
                                typeMatch(t.types, type)
                                        && t.version != null
                                        && t.version.equalsIgnoreCase(version))
                .findFirst();
    }

    private boolean typeMatch(List<String> types, String type) {
        return types != null && types.stream().anyMatch(t -> t != null && t.equalsIgnoreCase(type));
    }


}
