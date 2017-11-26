(ns clj.goodreads.core
  (:require [clojure.test :as t]
            [wellread.goodreads.utils :as utils]))

(t/deftest test-url
  (t/is
   (= (utils/build-url {:path ["review" "list" "6437129"] :format "xml" :params "v=2"})
      "https://www.goodreads.com/review/list/6437129.xml?key=k3y&v=2"
    )))

