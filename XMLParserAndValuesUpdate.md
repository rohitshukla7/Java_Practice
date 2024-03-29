import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UpdateXML {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory to parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("path/to/xml/file.xml");

            // Get the "trader_initials" node
            NodeList traderInitialsNodeList = doc.getElementsByTagName("trader_initials");
            Node traderInitialsNode = traderInitialsNodeList.item(0);

            // Update the "trader_initials" node's value
            traderInitialsNode.setTextContent("new_trader_initials_value");
            
            // Get the "user_login" node
            NodeList userLoginNodeList = doc.getElementsByTagName("user_login");
            Node userLoginNode = userLoginNodeList.item(0);
            
            // Update the "user_login" node's value
            userLoginNode.setTextContent("new_user_login_value");

            // Save the changes back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("path/to/xml/file.xml");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


For printing updated XML data
// Save the changes back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);
            
            // Print the updated XML data
            System.out.println(result.getWriter().toString());
