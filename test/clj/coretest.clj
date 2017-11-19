(ns clj.coretest
  (:require  [clojure.test :as t]
             [duniyahai.core :as core]))

(t/deftest do-stuff
  (t/is (= 9 9)))

