(ns compojure.api.examples.main
  (:gen-class))

(defn -main [& args]
  (require 'compojure.api.examples.server)
  (apply (resolve 'compojure.api.examples.server/start) args))
