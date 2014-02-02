(defproject metosin/compojure-api-examples "0.0.1"
  :description "Compojure-api-examples"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [metosin/compojure-api "0.0.1"]
                 [metosin/ring-swagger-ui "2.0.4"]]
  :ring {:handler compojure.api.examples.handler/app}
  :profiles {:uberjar {:resource-paths ["swagger-ui"]}
             :dev {:plugins [[lein-ring "0.8.10"]]}})
