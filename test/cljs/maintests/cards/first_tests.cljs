(ns cljs.maintests.cards.first-tests
  (:require [devcards.core :as dc :refer-macros [defcard deftest defcard-rg]]
            [duniyahai.core :as sut]
            [cljs.test :as t :refer-macros [is testing]]
            ))

(deftest root-test-separate
  (t/is (not-empty (sut/root))))

(deftest mouse-test2-separate
  (t/is (= 5 5)))


