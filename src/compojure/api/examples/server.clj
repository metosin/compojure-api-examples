(ns compojure.api.examples.server
  (:require [ring.adapter.jetty9 :refer [run-jetty]]
            [compojure.api.examples.handler :refer [app]])
  (:gen-class))

(defn -main [& args] (run-jetty #'app {:port 3000 :join? false}))
