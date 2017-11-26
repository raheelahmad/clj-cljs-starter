;; To be used with start-figwheel! if you wanna watch for devcards as well
(def fig-config
                  {:figwheel-options {}
                   :build-ids ["dev" "devcards"]
                   :all-builds
                   [
                    {:id "dev"
                     :source-paths ["src/cljs" "test/cljs"]
                      :figwheel {:on-jsload "wellread.core/mount-root"}
                     :compiler {:main "wellread.core"
                                 :output-to "resources/public/js/app.js"
                                 :output-dir  "resources/public/js/out"
                                 :asset-path "js/out"
                                 :source-map-timestamp true
                                 }}
                    {:id "devcards"
                     :source-paths ["src/cljs" "test/cljs"]
                      :figwheel {:devcards true}
                      ;; May need to append cljs to all namespaces anyway
                     :compiler {:main "cljs.maintests.browser-runner"
                                 :asset-path "js/devcards_out"
                                 :output-to "resources/public/js/wellread_devcards.js"
                                 :output-dir "resources/public/js/devcards_out"
                                 :optimizations :none
                                 :source-map-timestamp true}}
                    ]})
