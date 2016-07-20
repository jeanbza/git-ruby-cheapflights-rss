package com.cheapflights;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class CheapflightsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheapflightsApplication.class, args);
    }

    @Autowired
    @Scheduled(fixedDelay = 20000)
    public void updateRss(Feed feed, RestTemplate restTemplate) throws Exception {
        System.out.println("Updating rss feed");

        feed.entries.clear();

        String urlString = "http://www.thriftytraveler.com/";
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copy(is, baos);
        System.out.println(baos.toString());
    }
}
