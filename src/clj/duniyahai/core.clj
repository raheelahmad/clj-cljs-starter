(ns duniyahai.core
  (:require [hiccup.core :as hiccup]
            [compojure.core :refer [defroutes GET]]

            [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :as resource]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.util.response :as response]
            )
  (:gen-class))

(defn html-skeleton []
  (hiccup/html
   [:head
    [:title "Hiccup!"]
    [:link {:rel "stylesheet" :type "text/css" :href "css/style.css"}]
    ]
   [:body
    [:div {:id "app"}]
    [:script {:src "js/app.js" :type "text/javascript"}]
    [:script
     "duniyahai.core.init();"]
    ]))

(defroutes app
  (GET "/" [] (html-skeleton))
  )

(defn -main [port]
  (jetty/run-jetty
   (-> #'app (resource/wrap-resource "public"))
   {:port (Integer. port)}))

(defn -dev-main [port]
  (jetty/run-jetty
   (-> #'app (resource/wrap-resource "public") wrap-reload)
   {:port (Integer. port) :join? false}))

