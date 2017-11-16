(ns cljs.maintests.testrunner
  (:require [cljs.maintests.core]
            [doo.runner :refer-macros [doo-tests]]))

(doo-tests 'cljs.maintests.core)

(enable-console-print!)

(defn run-all-tests
  []
  (run-tests 'cljs.maintests.core))

