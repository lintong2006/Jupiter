package com.laioffer.job.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true) //ignorable type:"full time"
//indicates that other fields in the response can be safely ignored.
@JsonInclude(JsonInclude.Include.NON_NULL) //keywords:null
// indicates that null fields can be skipped and not included.
public class Item {
    private String id;
    private String title;
    private String location;
    private String companyLogo;
    private String url;
    private String description;
    private Set<String> keywords;
    private boolean favorite;

    @JsonProperty("id")
    //indicates the mapping. This field is optional if the property name is
    //the same as the JSON key
    public String getId() {
        return id;
    }
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }
    @JsonProperty("company_logo")
    public String getCompanyLogo() {
        return companyLogo;
    }
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }
    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Item(){
    }

    public Item(String id, String title, String location, String companyLogo, String url, String description, Set<String> keywords, boolean favorite) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.companyLogo = companyLogo;
        this.url = url;
        this.description = description;
        this.keywords = keywords;
        this.favorite = favorite;
    }
}
