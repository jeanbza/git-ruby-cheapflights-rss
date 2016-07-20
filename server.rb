require 'sinatra'

class MyApp < Sinatra::Base
  get '/' do
    require 'rss'

    $rss.to_s
  end
end
