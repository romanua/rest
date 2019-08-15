package com.ix.restful.model;

import java.util.List;

public class Strings {

    List<String> strings;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return "Strings{" +
                "strings=" + strings +
                '}';
    }
}
