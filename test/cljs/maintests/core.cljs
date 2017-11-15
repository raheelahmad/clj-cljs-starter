(ns cljs.maintests.core
  (:require  [cljs.test :as t :include-macros true]
             [duniyahai.core :as sut]))

(t/deftest mouse-test
  (t/is (not-empty (sut/root))))
