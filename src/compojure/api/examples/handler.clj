(ns compojure.api.examples.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [compojure.api.examples.domain :refer :all]
            [schema.core :as s]))

(defapi app
  (swagger-ui)
  (swagger-docs
    :title "Sample Api"
    :description "Compojure Api sample application")

  (swaggered "math"
    :description "math with parameters"
    (GET* "/plus" []
      :query-params [x :- Long y :- Long]
      :summary      "x+y with query-parameters"
      (ok {:total (+ x y)}))
    (POST* "/minus" []
      :body-params [x :- Long y :- Long]
      :summary     "x-y with body-parameters"
      (ok {:total (- x y)}))
    (GET* "/times/:x/:y" []
      :path-params [x :- Long y :- Long]
      :summary     "x*y with path-parameters"
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
      (PUT* "/anonymous" []
        :return [{:secret Boolean s/Keyword s/Any}]
        :body   [body [{:secret Boolean s/Keyword s/Any}]]
        (ok body))
      (GET* "/hello" []
        :return String
        :query-params [name :- String]
        (ok (str "Hello, " name)))
      (POST* "/pizza" []
        :return   NewSingleToppingPizza
        :body     [pizza NewSingleToppingPizza]
        :summary  "post echo of a pizza"
        (ok pizza))))

  (swaggered "pizza"
    :description "Pizza Api it is."
    (context "/api/pizzas" []
      (GET* "/" []
        :return  [Pizza]
        :summary "Gets all Pizzas"
        (ok (get-pizzas)))
      (POST* "/" []
        :return  Pizza
        :body    [pizza NewPizza {:description "new pizza"}]
        :summary "Adds a pizza"
        (ok (add! pizza)))
      (PUT* "/" []
        :return  Pizza
        :body    [pizza Pizza]
        :summary "Updates a pizza"
        (ok (update! pizza)))
      (GET* "/:id" []
        :return      Pizza
        :path-params [id :- Long]
        :summary     "Gets a pizza"
        (ok (get-pizza id)))
      (DELETE* "/:id" []
        :path-params [id :- Long]
        :summary  "Deletes a Pizza"
        (ok (delete! id))))))
