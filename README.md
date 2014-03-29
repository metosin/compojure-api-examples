# Compojure-api-examples

Example project for using [Compojure-api](https://github.com/metosin/compojure-api).

## Usage

### Running

`lein ring server`

### Packaging and running as standalone jar

```
lein do clean, ring uberjar
java -jar target/examples.jar
```

### Packaging as war

`lein ring uberwar`

## License

Copyright © 2014 Metosin Oy

Distributed under the Eclipse Public License, the same as Clojure.
