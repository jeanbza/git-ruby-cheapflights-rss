package com.cheapflights;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private final String title;
    private final String link;
    private final String description;
    private final String language;
    private final String copyright;
    private final String pubDate;

    public final List<FeedMessage> entries = new ArrayList<>();

    public Feed(String title, String link, String description, String language,
                String copyright, String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

    public List<FeedMessage> getMessages() {
        return entries;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getPubDate() {
        return pubDate;
    }

    @Override
    public String toString() {
        return "Feed{" +
            "title='" + title + '\'' +
            ", link='" + link + '\'' +
            ", description='" + description + '\'' +
            ", language='" + language + '\'' +
            ", copyright='" + copyright + '\'' +
            ", pubDate='" + pubDate + '\'' +
            ", entries=" + entries +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feed feed = (Feed) o;

        if (title != null ? !title.equals(feed.title) : feed.title != null) return false;
        if (link != null ? !link.equals(feed.link) : feed.link != null) return false;
        if (description != null ? !description.equals(feed.description) : feed.description != null) return false;
        if (language != null ? !language.equals(feed.language) : feed.language != null) return false;
        if (copyright != null ? !copyright.equals(feed.copyright) : feed.copyright != null) return false;
        if (pubDate != null ? !pubDate.equals(feed.pubDate) : feed.pubDate != null) return false;
        return entries != null ? entries.equals(feed.entries) : feed.entries == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (copyright != null ? copyright.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        result = 31 * result + (entries != null ? entries.hashCode() : 0);
        return result;
    }
}