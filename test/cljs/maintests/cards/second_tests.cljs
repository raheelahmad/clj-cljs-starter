(ns cljs.maintests.cards.second-tests
  (:require [devcards.core :as dc :refer-macros [defcard deftest defcard-rg]]
            [cljs.test :as t :refer-macros [is testing]]
            ))

(deftest second-test-3
  (t/is (= 9 9)))

(deftest second-test-2
  (t/is (= 5 5)))
