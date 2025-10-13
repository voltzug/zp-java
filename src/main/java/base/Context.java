package base;

public abstract class Context extends BaseObject {
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
