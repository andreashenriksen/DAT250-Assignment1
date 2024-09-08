package com.example.demo.models;


public class VoteOption {

    private String caption;
    private int presentationOrder;
    private Integer id;
    private static int counter;

    public VoteOption(String caption, int presentationOrder) {
        this.id = ++counter;
        this.caption = caption;
        this.presentationOrder = presentationOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }

}
