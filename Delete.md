           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            // Get the trader_initials element
            NodeList traderInitials = doc.getElementsByTagName("trader_initials");
            Node traderInitialsNode = traderInitials.item(0);

            // Set the new value for the trader_initials element
            traderInitialsNode.setTextContent("newValue");

            // Print the updated XML document
            TransformerFactory transformerFactory



// Create a transformer factory
TransformerFactory transformerFactory = TransformerFactory.newInstance();
// Create a transformer
Transformer transformer = transformerFactory.newTransformer();
// Set the output properties for the transformer
transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
transformer.setOutputProperty(OutputKeys.INDENT, "yes");

// Create a string writer to hold the updated XML
StringWriter writer = new StringWriter();
// Transform the document to the string writer
transformer.transform(new DOMSource(doc), new StreamResult(writer));

// Print the updated XML
System.out.println(writer.toString());
