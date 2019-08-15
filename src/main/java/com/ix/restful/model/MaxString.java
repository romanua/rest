package com.ix.restful.model;

import java.util.List;
import java.util.Objects;

public class MaxString  {

    private List<Response> response;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxString maxString = (MaxString) o;
        return Objects.equals(response, maxString.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response);
    }
}
