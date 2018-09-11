package com.villa.deimer.pruebatecnicavalid.model.entities;

import com.google.gson.annotations.SerializedName;

public class ImageItem {

    @SerializedName("#text")
    private String url;
    private String size;

    public ImageItem() {}
    public ImageItem(String url, String size) {
        this.url = url;
        this.size = size;
    }

    //region getters
    public String getUrl() {
        return url;
    }
    public String getSize() {
        return size;
    }
    //endregion

    //region Setters
    public void setUrl(String url) {
        this.url = url;
    }
    public void setSize(String size) {
        this.size = size;
    }
    //endregion

    @Override
    public String toString() {
        return "ImageItem{" +
                "url='" + url + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
