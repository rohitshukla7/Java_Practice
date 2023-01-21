Here is an example of how you can remove the text xsi:schemaLocation="http://www.w3.org/1999/XMLSchema-instance request.xsd" from the XML body and save the remaining XML body in a new String using Java:

Copy code
String xml = "<?xml version=\"1.0\" encoding = \"UTF-8\"?>" +
                "<request xsi:schemaLocation=\"http://www.w3.org/1999/XMLSchema-instance request.xsd\">" +
                "<user_login>roshukla</user_login>" +
                "<mbody>" +
                "<data>" +
                "<trader_initials><![CDATA[CK7]]></trader_initials>" +
                "</data>" +
                "</mbody>" +
                "</request>";
String modifiedXml = xml.replace("xsi:schemaLocation=\"http://www.w3.org/1999/XMLSchema-instance request.xsd\"", "");
System.out.println(modifiedXml);
This code will remove the specified text and save the remaining XML body in the modifiedXml variable.

It's worth noting that, this code works for this specific XML format and if the format of the xml is changed it may not work as expected.




Rohit Shukla
now write the script to add the removed text at the same location from where it was removed in modifiedXml
Here is an example of how you can add the text xsi:schemaLocation="http://www.w3.org/1999/XMLSchema-instance request.xsd" back to the modified XML body at the same location where it was removed:

Copy code
String originalXml = xml;
int indexOfRequest = modifiedXml.indexOf("<request");
String newXml = modifiedXml.substring(0, indexOfRequest) + "xsi:schemaLocation=\"http://www.w3.org/1999/XMLSchema-instance request.xsd\" " + modifiedXml.substring(indexOfRequest);
System.out.println(newXml);
This code will add the specified text at the same location where it was removed.

In this code, first, it finds the index of <request and then add the removed text at that index and save the new xml in newXml variable.

It's worth noting that, this code works for this specific XML format and if the format of the xml is changed it may not work as expected.



