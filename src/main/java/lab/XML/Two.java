package lab.XML;

import base.Context;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Two extends Context {
    public static String getEventTypeString(int eventType) {
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
    void structureTest(File file) throws XMLStreamException, IOException {
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

    @Override
    protected void execute() throws  IOException, XMLStreamException {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        File file = new File("data/test.xml");
        structureTest(file);
    }


    public static void main(String[] args){
        var l2 = new Two();
        l2.run();
    }
}
