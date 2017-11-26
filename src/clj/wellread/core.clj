(ns wellread.core
  (:require [hiccup.core :as hiccup]
            [hiccup.page :as page]
            [compojure.core :refer [defroutes GET]]

            [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :as resource]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.util.response :as response]
            )
  (:gen-class))

(defn html-skeleton []
  (page/html5
   [:head
    [:title "Well Read . org"]
    [:link {:rel "stylesheet" :type "text/css" :href "https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.1/css/bulma.min.css"}]
    [:link {:rel "stylesheet" :type "text/css" :href "css/style.css"}]]
   [:body
    [:section {:class "section"}
     [:div {:class "container"}
      [:div {:id "app"}]
      [:script {:src "js/app.js" :type "text/javascript"}]
      [:script
       "wellread.core.init();"]]]
    ]))

(defroutes app
  (GET "/" [] (html-skeleton)))

(defn -main [port]
  (jetty/run-jetty
   (-> #'app (resource/wrap-resource "public"))
   {:port (Integer. port)}))

(defn -dev-main [port]
  (jetty/run-jetty
   (-> #'app (resource/wrap-resource "public") wrap-reload)
   {:port (Integer. port) :join? false}))

