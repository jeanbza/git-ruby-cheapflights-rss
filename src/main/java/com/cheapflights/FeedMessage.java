package com.cheapflights;

public class FeedMessage {

    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;

    public FeedMessage(String title, String description, String link, String author, String guid) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.author = author;
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getAuthor() {
        return author;
    }

    public String getGuid() {
        return guid;
    }

    @Override
    public String toString() {
        return "FeedMessage{" +
            "title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", link='" + link + '\'' +
            ", author='" + author + '\'' +
            ", guid='" + guid + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedMessage that = (FeedMessage) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        return guid != null ? guid.equals(that.guid) : that.guid == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        return result;
    }
}