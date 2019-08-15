package com.ix.restful.service;

import com.ix.restful.model.MaxString;
import com.ix.restful.model.Strings;

public interface StringsService {
    Strings process(Strings strings);
    MaxString maxWord(Strings strings);
}
