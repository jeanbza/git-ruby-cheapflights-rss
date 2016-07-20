require_relative './rss'
require_relative './server'

MyRss.setup_rss

Thread.new {
  MyRss.recursively_setup_rss
}

puts 'Running app'
run MyApp
