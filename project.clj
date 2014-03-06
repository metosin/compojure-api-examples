(defproject metosin/compojure-api-examples "0.8.0"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [metosin/compojure-api "0.8.1"]
                 [metosin/ring-http-response "0.3.0"]
                 [metosin/ring-swagger-ui "2.0.12-1"]]
  :ring {:handler compojure.api.examples.handler/app}
  :profiles {:uberjar {:resource-paths ["swagger-ui"]}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.8.10"]]}})
