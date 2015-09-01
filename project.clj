(defproject metosin/compojure-api-examples "0.23.0"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clj-time "0.11.0"] ;; needed as `lein ring uberwar` is broken.
                 [metosin/compojure-api "0.23.0"]]
  :ring {:handler compojure.api.examples.handler/app}
  :uberjar-name "examples.jar"
  :uberwar-name "examples.war"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]
                       :aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.9.6"]]}})
