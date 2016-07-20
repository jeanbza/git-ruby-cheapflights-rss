package com.cheapflights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired private Feed feed;

    @RequestMapping("/")
    @ResponseBody
    public String handle() throws Exception {
        RSSFeedWriter rssFeedWriter = new RSSFeedWriter(feed);
        return rssFeedWriter.write();
    }
}
