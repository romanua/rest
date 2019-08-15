package com.ix.restful.model;

import java.util.Objects;

public class Response {

    private String string;
    private int longestWord;

    public Response(String string, int longestWord) {
        this.string = string;
        this.longestWord = longestWord;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(int longestWord) {
        this.longestWord = longestWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return longestWord == response.longestWord &&
                Objects.equals(string, response.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, longestWord);
    }
}
