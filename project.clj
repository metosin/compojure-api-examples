(defproject metosin/compojure-api-examples "0.15.0"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [metosin/compojure-api "0.15.0"]
                 [metosin/ring-http-response "0.4.1"]
                 [metosin/ring-swagger-ui "2.0.17"]
                 [clj-time "0.8.0"]]
  :ring {:handler compojure.api.examples.handler/app}
  :uberjar-name "examples.jar"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]
                       :aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.8.11"]]}})
