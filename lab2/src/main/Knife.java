package main;

public class Knife {
    public Knife(String type, String handy, String origin, Visual visual, boolean value, String id) {
        this.type = type;
        this.handy = handy;
        this.origin = origin;
        this.visual = visual;
        this.value = value;
        this.id = id;
    }

    public Knife() {
    }

    private String type;
    private String handy;
    private String origin;
    private Visual visual = new Visual();
    private boolean value;
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHandy() {
        return handy;
    }

    public void setHandy(String handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Visual getVisual() {
        return visual;
    }

    public void setVisual(Visual visual) {
        this.visual = visual;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("\nID: ");
        sb.append(id).append("\nType: ").append(type);
        sb.append("\nHandy: ").append(handy);
        sb.append("\nOrigin: ").append(origin ).append(visual);
        return sb.toString();
    }
}
