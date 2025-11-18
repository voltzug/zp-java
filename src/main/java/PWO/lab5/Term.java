package PWO.lab5;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Term {
    int minTemp;
    int maxTemp;
    int currentTemp;

    Term(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Term createInstance(int minTemp, int maxTemp) {
        return new Term(minTemp, minTemp);
    }

    public int getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(int currentTemp) {
        this.currentTemp = currentTemp;
    }

    public int addDegrees(int degrees) {
        if (degrees < 0) throw new IllegalArgumentException("add only positive");
        int res = currentTemp + degrees;
        if (_isOk(res)) {
            currentTemp = res;
            return currentTemp;
        }
        throw new IllegalStateException("restricted to term limits");
    }

    public int subtractDegrees(int degrees) {
        if (degrees < 0) throw new IllegalArgumentException("subtract only positive");
        int res = currentTemp - degrees;
        if (_isOk(res)) {
            currentTemp = res;
            return currentTemp;
        }
        throw new IllegalStateException("restricted to term limits");
    }

    public boolean isBelowZero() {
        return currentTemp < 0;
    }

    private boolean _isOk(int newTemp) {
        return newTemp >= minTemp && newTemp <= maxTemp;
    }
}
