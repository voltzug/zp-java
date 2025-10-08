package base;

public abstract class BaseObject {
    public final String name;
    /** false by default */
    public final boolean doDebug;

    public BaseObject() {
        this.name = "";
        this.doDebug = false;
    }
    public BaseObject(String name) {
        this.name = name;
        this.doDebug = false;
    }
    public BaseObject(String name, boolean doDebug) {
        this.name = name;
        this.doDebug = doDebug;
    }

    /**  Enter scene */
    public void init() {

    }

    /** Exit scene */
    public void dispose() {

    }
}
