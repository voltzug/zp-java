package lab.Internationalization;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    private Locale locale;
    ResourceBundle resourceBundle;

    public Language(@NotNull ELocale locale) {
        switch (locale){
            case PL -> {
                this.locale = new Locale("pl", "PL");
            }
            case EN -> {
                this.locale = new Locale("en", "UK");
            }
        }
        resourceBundle = ResourceBundle.getBundle( "messages", this.locale);
    }

    public String getMessageTitle(){
        return resourceBundle.getString("title");
    }
}
