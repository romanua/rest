package com.ix.restful.util;

import com.ix.restful.model.Response;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class ResponseComparator implements Comparator<Response> {


    @Override
    public int compare(Response o1, Response o2) {

        if(o1.getLongestWord() > o2.getLongestWord()) {
            return 1;
        } else if (o1.getLongestWord() == o2.getLongestWord()) {
            String o1String = o1.getString();
            if (o1String == null) {
                o1String = StringUtils.EMPTY;
            }
            String o2String = o2.getString();
            if (o2String == null) {
                o2String = StringUtils.EMPTY;
            }
            return  (o1String.compareTo(o2String));
        } else {
            return -1;
        }
    }
}
