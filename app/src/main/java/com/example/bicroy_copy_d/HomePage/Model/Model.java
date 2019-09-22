package com.example.bicroy_copy_d.HomePage.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uploadDate")
    @Expose
    private String uploadDate;
    @SerializedName("isAbaiable")
    @Expose
    private Boolean isAbaiable;
    @SerializedName("isAbailable")
    @Expose
    private Boolean isAbailable;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Boolean getIsAbaiable() {
        return isAbaiable;
    }

    public void setIsAbaiable(Boolean isAbaiable) {
        this.isAbaiable = isAbaiable;
    }

    public Boolean getIsAbailable() {
        return isAbailable;
    }

    public void setIsAbailable(Boolean isAbailable) {
        this.isAbailable = isAbailable;
    }

}