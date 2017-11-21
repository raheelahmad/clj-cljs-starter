(ns wellread.comps.shelf
  (:require [reagent.core :as r]))

(defn shelf-ui [{:keys [title img]}]
  [:div {:class "ze-card"}
   [:img {:src (:url img)}]
   [:div {:class "header"}
    title]
   ])

