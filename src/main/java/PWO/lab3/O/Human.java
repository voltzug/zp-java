package PWO.lab3.O;


abstract class Human {
    public abstract double getId();
}


class Student extends Human {
    private double index;

    public Student(double index) {
        this.index = index;
    }

    @Override
    public double getId() {
        return index;
    }
}


class Teacher extends Human {
    private double employeeNumber;

    public Teacher(double employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public double getId() {
        return employeeNumber;
    }
}

final class PeopleInfo {
    public double humanId(Human hmn) {
        return hmn.getId();
    }
}
