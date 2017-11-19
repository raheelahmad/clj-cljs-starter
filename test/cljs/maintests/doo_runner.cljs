(ns cljs.maintests.doo-runner
  (:require [cljs.maintests.cards.first-tests]
            [cljs.maintests.cards.second-tests]
            [cljs.maintests.simple-tests]
            [doo.runner :refer-macros [doo-tests]]))

(doo-tests 'cljs.maintests.simple-tests
           'cljs.maintests.cards.first-tests
           'cljs.maintests.cards.second-tests)

(enable-console-print!)

