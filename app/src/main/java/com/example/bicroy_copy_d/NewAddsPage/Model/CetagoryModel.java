package com.example.bicroy_copy_d.NewAddsPage.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CetagoryModel {

        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("name")
        @Expose
        private String name;

        public String getIcon() {
        return icon;
        }

        public void setIcon(String icon) {
        this.icon = icon;
        }

        public String getName() {
        return name;
        }

        public void setName(String name) {
        this.name = name;
        }

}