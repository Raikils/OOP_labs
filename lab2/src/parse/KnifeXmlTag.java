package parse;

public enum KnifeXmlTag {
    KNIFES("Knifes"),
    ID("ID"),
    KNIFE("Knife"),
    TYPE("Type"),
    HANDY("Handy"),
    ORIGIN("Origin"),
    LENGTH("Length"),
    WIDTH("Width"),
    MATERIAL("Material"),
    HANDLE("Handle"),
    WOODTYPE("WoodType"),
    BLOODSTREAM("Bloodstream"),
    VALUE("Value"),
    VISUAL("Visual");
    private String value;
    KnifeXmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
