(defproject metosin/compojure-api-examples "0.0.1"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [prismatic/schema "0.2.0"]
                 [metosin/compojure-api "0.0.1"]
                 [metosin/ring.swagger-ui "0.0.1"]]
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler compojure.api.examples.handler/app}
  :profiles {:uberjar {:resource-paths ["swagger-ui"]}
             :dev {:plugins [[lein-clojars "0.9.1"]
                             [lein-midje "3.1.1"]]
                   :dependencies [[ring-mock "0.1.5"]
                                  [javax.servlet/servlet-api "2.5"]
                                  [midje "1.6.0"]
                                  [clj-http "0.7.8" :exclusions [commons-codec]]]}})
