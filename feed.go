package main

import (
    "fmt"
    "strings"
    "time"
)

type feedItem struct {
    title       string
    link        string
    description string
}

type Feed struct {
    title         string
    link          string
    description   string
    lastBuildDate time.Time
    items         []*feedItem
}

func NewFeed(title, link, description string) *Feed {
    return &Feed{
        title: title,
        link: link,
        description: description,
        lastBuildDate: time.Now(),
    }
}

func (f *Feed) AddItem(title, link, description string) {
    newItem := &feedItem{
        title: title,
        link: link,
        description: description,
    }
    f.items = append(f.items, newItem)
}

func (f *Feed) Marshal() string {
    var itemsString []string

    f.lastBuildDate = time.Now()

    for _, item := range f.items {
        itemsString = append(itemsString, fmt.Sprintf(`
    <item>
        <title>%s</title>
        <link>%s</link>
        <description>%s</description>
    </item>
        `, item.title, item.link, item.description))
    }

    rssString := fmt.Sprintf(`
<?xml version="1.0" encoding="UTF-8" ?>
<rss version="2.0">

<channel>
  <title>%s</title>
  <link>%s</link>
  <description>%s</description>
  <lastBuildDate>%s</lastBuildDate>
  %s
</channel>
</rss>`, f.title, f.link, f.description, f.lastBuildDate.String(), strings.Join(itemsString, "\n"))

    return rssString
}