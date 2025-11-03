package lab.Internationalization;

import base.Context;

public class Five extends Context {
    @Override
    protected void execute() throws Exception {
        System.out.println(new Language(ELocale.PL).getMessageTest());
    }


    public static void main(String[] args){
        var l5 = new Five();
        l5.run();
    }
}
