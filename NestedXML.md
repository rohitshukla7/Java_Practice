import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Parse the XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader("<SOAP-ENV:Envelope xmlns:SOAPSDK1=\\\"http://www.w3.org/2001/XMLSchema\\\" xmlns:SOAPSDK2=\\\"http://www.w3.org/2001/XMLSchema-instance\\\" xmlns:SOAPSDK3=\\\"http://schemas.xmlsoap.org/soap/encoding/\\\" xmlns:SOAP-ENV=\\\"http://schemas.xmlsoap.org/soap/envelope/\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\" xmlns:xsd=\\\"http://www.w3.org/1999/XMLSchema\\\"><SOAP-ENV:Body><nsl:put xmlns:nsl=\\\"urn:otcOpt\\\" SOAP-ENV:encodingStyle = \\\"http://schemas.xmlsoap.org/soap/encoding/\\\"><msgtr xsi:type=\\\"xsd:string\\\"><?xml version='1.0' encoding = 'UTF-8'?><request xsi:schemaLocation='http://www.w3.org/1999/XMLSchema-instance request.xsd'><user_login>roshukla</user_login><mbody><data><trader_initials><![CDATA[CK7]]></trader_initials></data></mbody></request></msgtr></nsl:put></SOAP-ENV:Body></SOAP-ENV:Envelope>"));
        Document doc = db.parse(is);

        // Extract the value of the msgtr node
        NodeList nl = doc.getElementsByTagName("msgtr");
        Node n = nl.item(0);
        String msgtrValue = n.getTextContent();
        System.out.println(msgtrValue);
    }
}
