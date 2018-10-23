package army.controller;

import army.Army;
import army.model.User;
import army.settings.Settings;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReaderDOM {

    File xmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;
    static Logger logger = Logger.getLogger(XMLReaderDOM.class);

    public XMLReaderDOM() {
        String filePath = Settings.filePath + Settings.fileName;
        xmlFile = new File(filePath);
        dbFactory = DocumentBuilderFactory.newInstance();
    }

    public boolean Authentication(User u) {
        boolean found = false;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Soldier");
            //now XML is loaded as Document in memory, lets convert it to Object List
//            List<User> UsersList = new ArrayList<User>();
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                UsersList.add(getUsers(nodeList.item(i)));
//            }
            HashMap<String, Vector<String>> userlist = new HashMap<String, Vector<String>>();
            for (int i = 0; i < nodeList.getLength(); i++) {

                String[] user = getUsers(nodeList.item(i));
                Vector<String> usert = new Vector<String>();
                usert.add(user[1]);
                usert.add(user[2]);
                userlist.put(user[0], usert);
            }
            if (userlist.containsKey(u.getUsername()) && u.getPassword().equals(userlist.get(u.getUsername()).get(0)) ) {
                 User CurrentUser = User.getinstance();
                 CurrentUser.setUsertype(userlist.get(u.getUsername()).get(1));
                found = true;
            }

            //lets print Employee list information
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            logger.info((this.getClass().getName()));
            logger.warn(e1.toString());
        }
        return found;
    }

    private String[] getUsers(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        String[] user = new String[3];
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            user[0] = (getTagValue("UserName", element));
            user[1] = (getTagValue("PassWord", element));
            user[2] = (getTagValue("privilege", element));

        }

        return user;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public void addUser(String firstname, String lastname, String privilege) throws SAXException, IOException, TransformerConfigurationException, TransformerException {
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();

            Collection<InsertUser> users = new ArrayList<InsertUser>();
            users.add(new InsertUser(firstname, lastname, privilege));

            for (InsertUser usr : users) {
                // server elements
                Element newUser = doc.createElement("Soldier");

                Element Fname = doc.createElement("UserName");
                Fname.appendChild(doc.createTextNode(usr.getFirstName()));
                newUser.appendChild(Fname);

                Element Lname = doc.createElement("PassWord");
                Lname.appendChild(doc.createTextNode(usr.getLastName()));
                newUser.appendChild(Lname);

                Element priv = doc.createElement("privilege");
                priv.appendChild(doc.createTextNode(usr.getPrivilege()));
                newUser.appendChild(priv);

                root.appendChild(newUser);
            }

            DOMSource source = new DOMSource(doc);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (ParserConfigurationException ex) {
            java.util.logging.Logger.getLogger(XMLReaderDOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class InsertUser {

    private String FirstName;
    private String LastName;
    private String privilege;

    public InsertUser(String f, String l, String p) {
        this.FirstName = f;
        this.LastName = l;
        this.privilege = p;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}
