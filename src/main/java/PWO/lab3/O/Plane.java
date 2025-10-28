package PWO.lab3.O;


public class Plane {
    private double direction;

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void fly(FlightOperations operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Cannot perform operation");
        }
        operation.execute(this);
    }



    public interface FlightOperations {
        void execute(Plane plane);
    }


    public static class TurnRight implements FlightOperations {
        private double angle;

        public TurnRight(double angle) {
            this.angle = angle;
        }

        @Override
        public void execute(Plane plane) {
            double currentDirection = plane.getDirection();
            plane.setDirection(currentDirection + angle);
        }
    }

    public static class TurnLeft implements FlightOperations {
        private double angle;

        public TurnLeft(double angle) {
            this.angle = angle;
        }

        @Override
        public void execute(Plane plane) {
            double currentDirection = plane.getDirection();
            plane.setDirection(currentDirection - angle);
        }
    }
}
