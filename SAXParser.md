import java.io.StringWriter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXUpdateCDATA {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            String newValue = "newValue";
            StringWriter writer = new StringWriter();

            // Create a handler to handle the CDATA sections
            DefaultHandler handler = new DefaultHandler() {
                boolean trader_initials = false;
                StringBuilder sb = new StringBuilder();

                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    sb.append("<").append(qName).append(" ");
                    for (int i = 0; i < attributes.getLength(); i++) {
                        sb.append(attributes.getQName(i)).append("=").append("\"")
                                .append(attributes.getValue(i)).append("\" ");
                    }
                    sb.append(">");
                    if (qName.equalsIgnoreCase("trader_initials")) {
                        trader_initials = true;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (trader_initials) {
                        sb.append("<![CDATA[").append(newValue).append("]]>");
                        trader_initials = false;
                    } else {
                        sb.append(new String(ch, start, length));
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    sb.append("</").append(qName).append(">");
                }
            };

            // Parse the XML file
            saxParser.parse("file.xml", handler);
            String updatedXML = sb.toString();
            System.out.println("Updated XML: " + updatedXML);

            // Use a Transformer to convert the updated XML content to a Document object
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            Document doc = source.getNode().getOwnerDocument();
            System.out.println("Document object: " + doc);
        } catch (Exception e) {
        e.printStackTrace();
    }
    }
    }
