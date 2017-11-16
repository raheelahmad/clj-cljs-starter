(ns cljs.maintests.core
  (:require  [cljs.test :as t :include-macros true]
             [duniyahai.core :as sut]))

(t/deftest mouse-test
  (t/is (not-empty (sut/root))))

(t/deftest mouse-test1
  (t/is (= 2 2)))

(t/deftest mouse-test2
  (t/is (= 5 5)))
