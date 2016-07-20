require 'rss'
require 'nokogiri'
require 'httparty'

module MyRss
  def self.recursively_setup_rss
    puts 'Sleeping'
    sleep(60 * 60) # one hour
    MyRss.setup_rss
  end

  def self.setup_rss
    puts 'Updating rss'

    $rss = RSS::Maker.make('atom') do |maker|
      maker.channel.author = 'Jean de Klerk'
      maker.channel.updated = Time.now.to_s
      maker.channel.about = 'This channel is about cheap flights'
      maker.channel.title = 'Cheap Flights'

      response = HTTParty.get('http://www.thriftytraveler.com/')
      body = response.body
      page = Nokogiri::HTML(body)

      page.css('h2.post-title a').each do |a|
        maker.items.new_item do |item|
          item.link = a['href']
          item.title = a.text
          item.updated = Time.now.to_s
        end
      end
    end
  end
end
