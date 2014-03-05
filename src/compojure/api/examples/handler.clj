(ns compojure.api.examples.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [compojure.api.examples.domain :refer :all]))

(defapi app
  (swagger-ui)
  (swagger-docs
    :title "Sample Api"
    :description "Compojure Api sample application")
  (swaggered "pizza"
    :description "Pizza Api it is."
    (context "/api" []
      (GET* "/pizzas" []
        :return   [Pizza]
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
