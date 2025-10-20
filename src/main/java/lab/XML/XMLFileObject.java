package lab.XML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class XMLFileObject {
    protected File file;
    protected final XMLInputFactory xif;
    protected final XMLOutputFactory xof;

    public XMLFileObject(File file, XMLInputFactory xif, XMLOutputFactory xof){
        this.file = file;
        this.xif = xif;
        this.xof = xof;
    }

    protected abstract void setField(String name, String value) throws Exception;

    public void read() throws Exception {
        try(FileInputStream fis = new FileInputStream(file)){
            var xmlr = xif.createXMLStreamReader(fis);
            while (xmlr.hasNext()) {
                int eventType = xmlr.next();
                if (eventType == XMLStreamReader.START_ELEMENT) {
                    String elementName = xmlr.getLocalName();
                    eventType = xmlr.next(); // Move to text or other content
                    if (xmlr.hasText()) {
                        String value = xmlr.getText();
                        setField(elementName, value);
                    }
                }
            }
        }
    }
    public abstract void write() throws IOException, XMLStreamException;

    protected void testStructure() throws IOException, XMLStreamException {
        try (FileInputStream fis = new FileInputStream(file)){
            XMLStreamReader xmlr = XMLInputFactory.newFactory().createXMLStreamReader(fis);
            int eventType = xmlr.getEventType();
            System.out.println(getEventTypeString(eventType));
            while (xmlr.hasNext()){
                eventType = xmlr.next();
                System.out.println(getEventTypeString(eventType));
            }
        }
    }


    static String getEventTypeString(int eventType) {
        return switch (eventType) {
            case XMLEvent.START_ELEMENT -> "START_ELEMENT";
            case XMLEvent.END_ELEMENT -> "END_ELEMENT";
            case XMLEvent.PROCESSING_INSTRUCTION -> "PROCESSING_INSTRUCTION";
            case XMLEvent.CHARACTERS -> "CHARACTERS";
            case XMLEvent.COMMENT -> "COMMENT";
            case XMLEvent.START_DOCUMENT -> "START_DOCUMENT";
            case XMLEvent.END_DOCUMENT -> "END_DOCUMENT";
            case XMLEvent.ENTITY_REFERENCE -> "ENTITY_REFERENCE";
            case XMLEvent.ATTRIBUTE -> "ATTRIBUTE";
            case XMLEvent.DTD -> "DTD";
            case XMLEvent.CDATA -> "CDATA";
            case XMLEvent.SPACE -> "SPACE";
            default -> "UNKNOWN_EVENT_TYPE , " + eventType;
        };
    }
}
