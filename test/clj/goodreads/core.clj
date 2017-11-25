(ns clj.goodreads.core
  (:require [clojure.test :as t]
            [wellread.goodreads.utils :as utils]))

(t/deftest test-url
  (t/is
      (= (utils/build-url "b") "b")
      ))

