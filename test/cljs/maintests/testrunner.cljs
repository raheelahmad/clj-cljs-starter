(ns cljs.maintests.testrunner
  (:require [cljs.test :refer-macros [run-tests]]
            [cljs.maintests.core]))

(enable-console-print!)

(defn run-all-tests
  []
  (run-tests 'cljs.maintests.core))

