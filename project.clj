(defproject metosin/compojure-api-examples "0.20.3"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-time "0.9.0"] ;; needed as `lein ring` is broken.
                 [metosin/compojure-api "0.20.3"]
                 [metosin/ring-http-response "0.6.1"]
                 [metosin/ring-swagger-ui "2.1.1-M2"]]
  :ring {:handler compojure.api.examples.handler/app}
  :uberjar-name "examples.jar"
  :uberwar-name "examples.war"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]
                       :aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.9.4"]]}})
