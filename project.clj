(defproject metosin/compojure-api-examples "1.1.0"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [metosin/compojure-api "1.1.13"]]
  :ring {:handler compojure.api.examples.handler/app}
  :uberjar-name "examples.jar"
  :uberwar-name "examples.war"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "4.0.1"]]
                   :plugins [[lein-ring "0.12.6"]]}})
