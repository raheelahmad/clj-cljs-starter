(ns wellread.core
  (:require [reagent.core :as r]
            [wellread.comps.shelf :as shelf]))

(defn root []
  [:div
   [:h1 {:class "title"} "Well Read!"]
   [shelf/shelf-ui]])

(defn mount-root []
  (r/render [root]
            (.getElementById js/document "app")
            ))

(defn ^:export init
  "This will be called by JS in the index.html.
  Do any initialization + setting up the initial UI."
  []
  (mount-root)
  )

