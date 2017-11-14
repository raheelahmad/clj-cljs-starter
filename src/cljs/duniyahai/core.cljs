(ns duniyahai.core
  (:require [reagent.core :as r]))

(defn root []
  [:h1
   "Rendered by reagent"])

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

