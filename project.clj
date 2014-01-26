(defproject metosin/compojure-api-examples "0.0.1"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [info.sunng/ring-jetty9-adapter "0.3.0"]
                 [metosin/compojure-api "0.0.1"]]
  :main compojure.api.examples.main
  :profiles {:uberjar {:aot [compojure.api.examples.main]
                       :resource-paths ["swagger-ui"]}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})
