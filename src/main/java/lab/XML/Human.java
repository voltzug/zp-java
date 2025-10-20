package lab.XML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public abstract class Human extends XMLFileObject {
    static final String propName = "name", propAge = "age", propHeight = "height";
    int age;
    double height;
    String name;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Human(String name, int age, double height, File file, XMLInputFactory xif, XMLOutputFactory xof) {
        super(file, xif, xof);
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    protected void setField(String name, String value) throws NumberFormatException {
        switch (name){
            case propName:
                this.name = value;
                return;
            case propAge:
                this.age = Integer.parseInt(value);
                return;
            case propHeight:
                this.height = Double.parseDouble(value);
                return;
        }
    }

    @Override
    public void write() throws IOException, XMLStreamException {

    }
}
