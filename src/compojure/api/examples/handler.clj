(ns compojure.api.examples.handler
  (:require [compojure.api.sweet :refer :all]
            [compojure.api.examples.domain :refer :all]))

(defapi app
  (swagger-ui)
  (swagger-docs "/api/docs"
    :title "Cool api"
    :description "Compojure Sample Web Api")
  (swaggered "sample"
    :description "sample api"
    (context "/api" []
      (GET* "/pizzas" []
        :return   Pizza
        :summary  "Gets all Pizzas"
        (ok (get-pizzas)))
      (GET* "/pizzas/:id" [id]
        :return   Pizza
        :summary  "Gets a pizza"
        (ok (get-pizza (->Long id))))
      (POST* "/pizzas" []
        :return   Pizza
        :body     [pizza NewPizza {:description "new pizza"}]
        :summary  "Adds a pizza"
        (ok (add! pizza)))
      (PUT* "/pizzas" []
        :return   Pizza
        :body     [pizza Pizza]
        :summary  "Updates a pizza"
        (ok (update! pizza)))
      (DELETE* "/pizzas/:id" [id]
        :return   Pizza
        :summary  "Deletes a Pizza"
        (ok (delete! (->Long id)))))))
