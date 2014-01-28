(defproject metosin/compojure-api-examples "0.0.1"
  :description "Compojure-api-examples"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [info.sunng/ring-jetty9-adapter "0.3.0"]
                 [metosin/compojure-api "0.0.1"]]
  :main compojure.api.main
  :start compojure.api.examples.server/start
  :profiles {:uberjar {:aot [compojure.api.main]
                       :resource-paths ["swagger-ui"]}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})
