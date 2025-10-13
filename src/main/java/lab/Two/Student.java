package lab.Two;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import java.io.File;

public class Student extends Human {
    static final String propId = "id";
    int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name, int age, double height, File file, XMLInputFactory xif, XMLOutputFactory xof) {
        super(name, age, height, file, xif, xof);
        this.id = id;
    }

    @Override
    protected void setField(String name, String value) throws NumberFormatException {
        super.setField(name, value);
        switch (name){
            case propId:
                this.id = Integer.parseInt(value);
                return;
        }
    }
}
