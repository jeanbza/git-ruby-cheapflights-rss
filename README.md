# Cheap flights rss feed

## Running

1. `go build main.go feed.go`
1. `./main`

## Deploying

1. `GOOS=linux go build main.go feed.go`
1. `cf login`
1. `cf push`