(ns duniyahai.core
  (:require [reagent.core :as r]))

(defn counter-ui []
  (let [c (r/atom 0)]
    (fn []
      [:div
       [:button
        {:on-click (fn []
                     (swap! c inc))}
        "Increment"]
       [:div (str "I am at " @c)]])))

(defn root []
  [:div
   [:h1
    "Rendered by reagent"]
   [counter-ui]])

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

