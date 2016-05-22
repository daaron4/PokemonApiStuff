package com.companyname.apistuff;

/**
 * Created by David on 5/20/2016.
 */
public class Name {

    private String specialCharacters;
    private Language language;

    public Name(String specialCharacters, Language language) {
        this.specialCharacters = specialCharacters;
        this.language = language;
    }

    public String getSpecialCharacters() {
        return specialCharacters;
    }

    public void setSpecialCharacters(String specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
