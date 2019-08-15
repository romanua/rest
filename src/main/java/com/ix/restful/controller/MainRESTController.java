package com.ix.restful.controller;

import com.ix.restful.model.MaxString;
import com.ix.restful.model.Strings;
import com.ix.restful.service.StringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRESTController {

    @Autowired
    private StringsService stringsService;

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MaxString getMaxStrings(@RequestBody Strings strings) {

        return stringsService.maxWord(strings);
    }

}
