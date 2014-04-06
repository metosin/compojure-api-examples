(ns compojure.api.examples.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [compojure.api.examples.domain :refer :all]))

(defapi app
  (swagger-ui)
  (swagger-docs
    :title "Sample Api"
    :description "Compojure Api sample application")
  (swaggered "math"
    :description "math with query & path params"
    (GET* "/sum" []
      :query-params [x :- Long y :- Long]
      :summary      "sums x & y query-parameters"
      (ok {:total (+ x y)}))
    (GET* "/times/:x/:y" []
      :path-params [x :- Long y :- Long]
      :summary     "multiplies x & y path-parameters"
      (ok {:total (* x y)})))
  (swaggered "echo"
    :description "request echoes"
    (context "/echo" []
      (GET* "/request" req (ok (dissoc req :body)))
      (GET* "/pizza" []
        :return   NewSingleToppingPizza
        :query    [pizza NewSingleToppingPizza]
        :summary  "get echo of a pizza"
        (ok pizza))
      (POST* "/pizza" []
        :return   NewSingleToppingPizza
        :body     [pizza NewSingleToppingPizza]
        :summary  "post echo of a pizza"
        (ok pizza))))
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
