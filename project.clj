(defproject wellread "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.854"]
                 [ring "1.6.2"]
                 [hiccup "1.0.5"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.6.0"]
                 [reagent "0.7.0"]
                 [lein-doo "0.1.8"]
                 [devcards "0.2.5-SNAPSHOT"]
                 [cprop "0.1.11"]]

  :min-lein-version "2.7.1"
  ;; This is the jar that will be available in the target/uberjar
  :uberjar-name "wellread.jar"
  ;; this is where the file where -main should be find
  :main wellread.core

  ;; where the compiled JAR will be placed
  :target-path "target/%s"

  :plugins [[lein-cljsbuild "1.1.7"]] ;; compiler to JS

  ;; find compilable files
  :source-paths ["src/clj" "src/cljs"]

  ;; only clean compiled & target dirs; forget about the whole project
  :clean-targets ^{:protect false} ["resources/public/js"
                                    "target"]

  :figwheel {:nrepl-port 7002
             :css-dirs ["resources/public/css"]}

  ;; uberjar profile is to compile to Java
  :profiles {
             :uberjar {:aot :all}
             :dev {:dependencies [[figwheel-sidecar "0.5.13"]
                                  [com.cemerick/piggieback "0.2.2"] ;; needed for nREPL
                                  [org.clojure/tools.nrepl "0.2.10"]
                                  [binaryage/dirac "1.2.16"]
                                  ]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

                   :plugins [[lein-figwheel "0.5.13"]
                             [lein-doo "0.1.8"]]
                   ;; only include resources in dev (where assets are found)
                   ;; for production (uberjar), resources will be kept separate.
                   :resource-paths ["resources"]
                   }}
  :cljsbuild {:builds {:dev {:source-paths ["src/cljs" "test/cljs"]
                            :figwheel {:on-jsload "wellread.core/mount-root"}
                            :compiler {:main wellread.core
                                       :output-to "resources/public/js/app.js"
                                       :output-dir  "resources/public/js/out"
                                       :asset-path "js/out"
                                       :source-map-timestamp true}}
                       :prod {:source-paths ["src/cljs"]
                              :compiler {
                                         :output-to "resources/public/js/app.js"
                                         :optimizations :advanced
                                         :pretty-print true
                                         :pseudo-names true
                                         }}
                       :devcards {:source-paths ["src/cljs" "test/cljs"]
                                  :figwheel {:devcards true}
                                  ;; May need to append cljs to all namespaces anyway
                                  :compiler {:main cljs.maintests.browser-runner
                                             :asset-path "js/devcards_out"
                                             :output-to "resources/public/js/wellread_devcards.js"
                                             :output-dir "resources/public/js/devcards_out"
                                             :optimizations :none
                                             :source-map-timestamp true}}
                       :test {:source-paths ["src/cljs" "test/cljs"]
                              :compiler {:output-to "resources/public/js/testable.js"
                                         :output-dir "resources/public/js/out_tests"
                                         :main cljs.maintests.doo-runner
                                         :optimizations :none
                                         }
                              }
                       }

              })
