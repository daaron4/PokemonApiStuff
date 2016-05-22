package com.companyname.apistuff;

import java.net.URL;

/**
 * Created by David on 5/20/2016.
 */
public class Language {

    private String languageName;
    private URL url;

    public Language(String languageName, URL url) {
        this.languageName = languageName;
        this.url = url;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
