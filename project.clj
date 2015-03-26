(defproject metosin/compojure-api-examples "0.17.0"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [metosin/ring-swagger "0.18.1"]
                 [metosin/compojure-api "0.18.0-SNAPSHOT"]
                 [metosin/ring-http-response "0.6.0"]
                 [metosin/ring-swagger-ui "2.1.8-M1"]
                 [clj-time "0.9.0"]]
  :ring {:handler compojure.api.examples.handler/app}
  :uberjar-name "examples.jar"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]
                       :aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.9.2"]]}})
