package base;

public abstract class Context extends BaseObject implements Runnable {
    public Context(){
        super();
    }
    public Context(String name) {
        super(name);
    }
    public Context(String name, boolean doDebug) {
        super(name, doDebug);
    }

    @Override
    protected abstract void execute() throws Exception;

    public void run(){
        try{
            execute();
        } catch(Exception exc){
            if(doDebug){
                System.out.println(getName()+"::run:"+exc.getMessage());
            }
        }
    }
}
