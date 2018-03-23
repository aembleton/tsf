# TSF
Provides REST endpoints for getting prime numbers and the second result in a Google Search

## Download
[Click here to download the JAR from Github](https://github.com/aembleton/tsf/raw/master/build/libs/tsf-1.0.0.jar)

## Run it
At the command line, run the following `java -jar tsf-1.0.0.jar`

The server will start up on port 4567

## Endpoints
- **`/prime/{max}/trial`** Creates a JSON list of prime numbers up to and including the max value using the [trial algorithm](https://en.wikipedia.org/wiki/Trial_division).  For example, [`http://localhost:4567/prime/43/trial`](http://localhost:4567/prime/43/trial)
- **`/prime/{max}/wilson`** Creates a JSON list of prime numbers up to and including the max value using [Wilson's theorum](https://primes.utm.edu/notes/proofs/Wilsons.html).  For example, [`http://localhost:4567/prime/42/wilson`](http://localhost:4567/prime/42/wilson)
- **`google/{query}`** Gets the second result of a Google query.  For example, [`http://localhost:4567/google/tsf`](http://localhost:4567/google/tsf)