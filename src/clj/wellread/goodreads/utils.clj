(ns wellread.goodreads.utils
  (:require [environ.core :refer [env]]
            [clojure.string :as str]))

(defn- goodread-key []
  (env :goodreads-key))
(defn- goodread-secret []
  (env :goodreads-secret))

;; ;; https://www.goodreads.com/review/list/6436970.xml?key=vGylzXcCulXsyovcHu0A&v=2 
;; (defn shelves-url [user-id]
;;   (build-url ["reviews" "list" user-id]))

(defn build-url [{:keys [path format params]}]
  (let [base "https://www.goodreads.com/"
        key (env :goodreads-key)
        path-str (str/join "/" path)
        url (str base path-str)
        q-params (str "key=" key "&" params)]
    (str url "." format "?" q-params)))


