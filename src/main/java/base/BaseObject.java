package base;

public abstract class BaseObject {
    private final String name;
    public String getName() {
        if(name.isEmpty()) return "";
        else return "["+name+"]";
    }
    /** false by default */
    public final boolean doDebug;

    public BaseObject() {
        this.name = "";
        this.doDebug = false;
        init();
    }
    public BaseObject(String name) {
        this.name = name;
        this.doDebug = false;
        init();
    }
    public BaseObject(String name, boolean doDebug) {
        this.name = name;
        this.doDebug = doDebug;
        init();
    }

    /**  Enter scene */
    protected void init() {
        if(doDebug){
            System.out.println(getName() + "::init()");
        }
    }
    /** Exit scene */
    protected void dispose() {
        if(doDebug){
            System.out.println(getName() + "::dispose()");
        }
    }
    protected abstract void execute() throws Exception;
}
