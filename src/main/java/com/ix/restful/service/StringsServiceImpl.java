package com.ix.restful.service;

import com.ix.restful.model.MaxString;
import com.ix.restful.model.Response;
import com.ix.restful.util.ResponseComparator;
import com.ix.restful.model.Strings;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StringsServiceImpl implements StringsService {

    @Override
    public Strings process(Strings strings) {
        return strings;
    }

    @Override
    public MaxString maxWord(Strings strings) {
        MaxString maxString = new MaxString();
        List<Response> responseList = new ArrayList<>();


        for (String string : strings.getStrings()) {
            String [] word = string.split(" ");
            String maxlethWord = "";
            for (String s : word) {
                if (s.length() >= maxlethWord.length()) {
                    maxlethWord = s;
                }

            }
            Response response = new Response(string, maxlethWord.length());
            responseList.add(response);
        }

        responseList.sort(new ResponseComparator().reversed());

        maxString.setResponse(responseList.stream().limit(5).collect(Collectors.toList()));

        return maxString;
    }

}
