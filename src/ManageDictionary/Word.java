package ManageDictionary;

import java.io.Serializable;

public class Word implements Serializable {
    private String name;
    private String meaning;
    private String adjective;
    private String noun;
    private String verb;
    private String synonym;

    public Word(String name, String meaning, String adjective, String noun, String verb, String synonym) {
        this.name = name;
        this.meaning = meaning;
        this.adjective = adjective;
        this.noun = noun;
        this.verb = verb;
        this.synonym = synonym;
    }

    public Word() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }
}
