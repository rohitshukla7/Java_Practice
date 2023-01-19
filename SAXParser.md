import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXUpdateCDATA {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Create a handler to handle the CDATA sections
            DefaultHandler handler = new DefaultHandler() {
                boolean trader_initials = false;
                String newValue = "newValue";

                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("trader_initials")) {
                        trader_initials = true;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (trader_initials) {
                        System.out.println("Old value: " + new String(ch, start, length));
                        System.out.println("New value: " + newValue);
                        trader_initials = false;
                    }
                }
            };

            // Parse the XML file
            saxParser.parse("file.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
