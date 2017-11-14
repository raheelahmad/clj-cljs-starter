(defproject clj-bart "0.1.0-SNAPSHOT"
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
                 [reagent "0.7.0"]]
  :min-lein-version "2.7.1"
  :uberjar-name "duniyahai.jar"
  :main duniyahai.core

  :target-path "target/%s"

  :plugins [[lein-cljsbuild "1.1.7"]] ;; compiler to JS

  ;; find compilable files
  :source-paths ["src/clj" "src/cljs"]

  ;; only clean compiled & target dirs; forget about the whole project
  :clean-targets ^{:protect false} ["resources/public/js"
                                    "target"]

  :figwheel {:nrepl-port 7002
             :css-dirs ["resources/public/css"]
             :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  ;; uberjar profile is to compile to Java
  :profiles {
             :uberjar {:aot :all
                       :hooks [leiningen.cljsbuild]}
             :dev {:dependencies [[figwheel-sidecar "0.5.13"]
                                  [com.cemerick/piggieback "0.2.2"] ;; needed for nREPL
                                  [binaryage/dirac "1.2.16"]
                                  ]
                   :plugins [[lein-figwheel "0.5.13"]
                             [lein-doo "0.1.7"]]
                   }}
  :cljsbuild {:builds {:dev {:source-paths ["src/cljs"]
                            :figwheel {:on-jsload "duniyahai.core/mount-root"}
                            :compiler {:main duniyahai.core
                                       :output-to "resources/public/js/app.js"
                                       :output-dir  "resources/public/js/out"
                                       :asset-path "js/out"
                                       :source-map-timestamp true}}
                       :prod {:source-paths ["src/cljs"]
                              :figwheel false
                              :compiler {:main duniyahai.core
                                         :output-to "resources/public/js/app.js"
                                         :optimizations :advanced
                                         :asset-path "js/out"
                                         :pretty-print false
                                         }}
                       }

              })