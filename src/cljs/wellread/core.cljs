(ns wellread.core
  (:require [reagent.core :as r]
            [wellread.comps.shelf :as shelf]))

(def books [{:title "Next of Kin: My Conversations with Chimpanzees "
             :img {:url "https://images.gr-assets.com/books/1348810069l/325779.jpg"}}
            {:title "The Call of the Wild"
             :img {:url "https://images.gr-assets.com/books/1452291694l/1852.jpg"}}
             {:title "The Catcher in the Rye"
              :img {:url "https://images.gr-assets.com/books/1398034300l/5107.jpg"}}
            ])

(defn root []
  [:div
   [:h1 {:class "title"} "Well Read!"]]
  (into [:div]
        (map #(shelf/shelf-ui %) books))
  )

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

