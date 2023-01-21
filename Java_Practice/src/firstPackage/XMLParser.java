import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.nio.file.Paths;

public class XMLParser {
    public static void main(String[] args) throws Exception {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // Create a DocumentBuilder
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Parse the outer XML
        String outerXML = Paths.get("C:\\Users\\zrohi\\AutomationWorkspace\\src\\Test.xml").toAbsolutePath().toString();
        //String outerXML = "<SOAP-ENV:Envelope xmlns:SOAPSDK1=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAPSDK2=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAPSDK3=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\"><SOAP-ENV:Body><nsl:put xmlns:nsl=\"urn:otcOpt\" SOAP-ENV:encodingStyle = \"http://schemas.xmlsoap.org/soap/encoding/\"><msgtr xsi:type=\"xsd:string\"> &lt;?xml version=&quot;1.0&quot; encoding = &quot;UTF-8&quot;?&gt; &lt;request xsi:schemaLocation=&quot;http://www.w3.org/1999/XMLSchema-instance request.xsd&quot;&gt; &lt;user_login&gt;roshukla&lt;/user_login&gt; &lt;mbody&gt; &lt;data&gt; &lt;trader_initials&gt;&lt;![CDATA[CK7]]&gt;&lt;/trader_initials&gt; &lt;/data&gt; &lt;/mbody&gt; &lt;/request&gt; </msgtr></nsl:put></SOAP-ENV:Body></SOAP-ENV:Envelope>";
//        InputSource is = new InputSource();
//        is.setCharacterStream(new StringReader(outerXML));
        //Document doc = db.parse(new File(outerXML));
        Document doc = db.parse(outerXML);
        System.out.println("outer XML:"+doc);

        // Get the value of the <msgtr> node
        NodeList msgtrNodes = doc.getElementsByTagName("msgtr");
        Node msgtrNode = msgtrNodes.item(0);
        String innerXML = msgtrNode.getTextContent();
        System.out.println("Inner XML: " + innerXML);

        // parse the inner XML
//        InputSource innerIs = new InputSource();
//        innerIs.setCharacterStream(new StringReader(innerXML));
        String tweakXML = "<?xml version=\"1.0\" encoding = \"UTF-8\"?>\n" +
                "                <request>\n" +
                "                <user_login>roshukla</user_login>\n" +
                "                <mbody>\n" +
                "                <data>\n" +
                "                <trader_initials><![CDATA[CK7]]></trader_initials>\n" +
                "                </data>\n" +
                "                </mbody>\n" +
                "                </request>";
        Document innerDoc = db.parse(new InputSource(new StringReader(tweakXML)));
        //cannot directly pass the string as argument otherwise we will get Exception in thread "main" java.net.MalformedURLException: no protocol: <?xml version="1.0" encoding = "UTF-8"?>

        // Get the value of the <trader_initials> node
        NodeList traderInitialsNodes = innerDoc.getElementsByTagName("trader_initials");
        Node traderInitialsNode = traderInitialsNodes.item(0);
        String traderInitialsValue = traderInitialsNode.getTextContent();
        System.out.println("trader_initials value: " + traderInitialsValue);
    }
}
