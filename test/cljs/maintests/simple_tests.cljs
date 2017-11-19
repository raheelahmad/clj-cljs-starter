(ns cljs.maintests.simple-tests
  (:require [duniyahai.core :as sut]
            [devcards.core :as dc :refer-macros [defcard deftest defcard-rg]]
            [cljs.test :as t :refer-macros [is testing]]
            ))

(deftest root-test-separate
  (t/is (not-empty (sut/root))))

(deftest mouse-test2-separate
  (t/is (= 6 6)))

