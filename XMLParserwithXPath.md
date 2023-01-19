import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class UpdateXML {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory to parse the XML data
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML data
            String xmlData = "<SOAP-ENV:Envelope>\n" +
                             "<SOAP-ENV:Body>\n" +
                             "<ns1:put xmlns:nsl = \"urn:otcOpt\" SOAP-ENV:encoding style = \"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                             "<msgtr xsi:type=\"xsd:string\">\n" +
                             "&lt;?xml version=&quot;1.0&quot; encoding = &quot;UTF-8&quot;?&gt;\n" +
                             "&lt;request xmlns:xsi=&quot;http://www.w3.org/1999/XMLSchema-instance&quote;request.xsd&quot;&gt;\n" +
                             "&lt;user_login&gt;roshukla&lt;/user_login&gt;\n" +
                             "&lt;mbody&gt;\n" +
                             "&lt;data&gt;\n" +
                             
                             
            StringReader sr = new StringReader(xmlData);
            InputSource is = new InputSource(sr);
            Document doc = builder.parse(is);

            // Create an XPath object
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Update the trader_initials element
            String newValue = "NEW_VALUE";
            Node trader_initials = (Node) xpath.evaluate("//trader_initials", doc, XPathConstants.NODE);
            trader_initials.setTextContent(newValue);

            // Print the updated XML data
            System.out.println(xmlData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
