package main;

import java.lang.String;

public class Visual {
    public Visual() {
        this.length = 10f;
        this.width = 10f;
        this.material = "";
        this.handle = "";
        this.woodType = "";
        this.bloodstream = false;
    }

    public Visual(float length, float width, String material, String handle, boolean bloodstream) {
        this.length = length;
        this.width = width;
        this.material = material;
        this.handle = handle;
        this.bloodstream = bloodstream;
    }

    public Visual(float length, float width, String material, String handle, String woodType, boolean bloodstream) {
        this.length = length;
        this.width = width;
        this.material = material;
        this.handle = handle;
        this.woodType = woodType;
        this.bloodstream = bloodstream;
    }

    private float length;
    private float width;
    private String material;
    private String handle;
    private String woodType;
    private boolean bloodstream;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public boolean isBloodstream() {
        return bloodstream;
    }

    public void setBloodstream(boolean bloodstream) {
        this.bloodstream = bloodstream;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("\nVisual:\n\tLength:");
        sb.append(length).append("\n\tWidth: ").append(width);
        sb.append("\n\tMaterial: ").append(material);
        sb.append("\n\tHandle: ").append(handle);
        if (handle.equals("wood")) sb.append("\n\tWoodType: ").append(woodType);
        sb.append("\n\tBloodstream: ").append(bloodstream);
        return sb.toString();
    }
}
