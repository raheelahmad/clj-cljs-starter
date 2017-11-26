(ns wellread.goodreads.utils
  (:require [environ.core :refer [env]]))

(defn- goodread-key []
  (env :goodreads-key))
(defn- goodread-secret []
  (env :goodreads-secret))

;; ;; https://www.goodreads.com/review/list/6436970.xml?key=vGylzXcCulXsyovcHu0A&v=2 
;; (defn shelves-url [user-id]
;;   (build-url ["reviews" "list" user-id]))

(defn build-url [frags]
  (env :goodreads-key))

