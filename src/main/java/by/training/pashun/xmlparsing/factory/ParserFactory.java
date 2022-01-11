package by.training.pashun.xmlparsing.factory;

import by.training.pashun.xmlparsing.exception.ParserException;
import by.training.pashun.xmlparsing.parser.AbstractFlowerParser;
import by.training.pashun.xmlparsing.parser.DOMFlowerParser;
import by.training.pashun.xmlparsing.parser.SAXFlowerParser;
import by.training.pashun.xmlparsing.parser.StAXFlowerParser;

public class ParserFactory {

    private static final ParserFactory INSTANCE =  new ParserFactory ();
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private ParserFactory() {
    }

    public static ParserFactory getInstance() {
        return INSTANCE;
    }

    public AbstractFlowerParser createFlowerParser(String typeParser) throws ParserException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DOMFlowerParser ();
            case STAX:
                return new StAXFlowerParser ();
            case SAX:
                return new SAXFlowerParser ();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
