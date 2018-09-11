package com.villa.deimer.pruebatecnicavalid.model.entities;

public class Wiki {

    private String published;
    private String summary;
    private String content;

    public Wiki() {}
    public Wiki(String published, String summary, String content) {
        this.published = published;
        this.summary = summary;
        this.content = content;
    }

    //region Getters
    public String getPublished() {
        return published;
    }
    public String getSummary() {
        return summary;
    }
    public String getContent() {
        return content;
    }
    //endregion

    //region Setters
    public void setPublished(String published) {
        this.published = published;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public void setContent(String content) {
        this.content = content;
    }
    //endregion

    @Override
    public String toString() {
        return "Wiki{" +
                "published='" + published + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
