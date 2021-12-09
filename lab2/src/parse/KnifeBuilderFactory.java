package parse;

public class KnifeBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    private KnifeBuilderFactory() {
    }
    public static AbstractKnifesBuilder createKnifeBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new KnifesDomBuilder();
            }
            case STAX -> {
                return new KnifesStaxBuilder();
            }
            case SAX -> {
                return new KnifesSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
