(defproject todomvc "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :jvm-opts ^:replace ["-Xmx1g" "-server"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [secretary "0.4.0"]
                 [om "0.3.6"]]

  :plugins [[lein-cljsbuild "1.0.2"][com.cemerick/austin "0.1.3"]]
  :repl-options { :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :source-paths ["src"]
  :injections [(require '[cemerick.austin.repls :refer (exec) :rename {exec austin-exec}])]
  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src"]
              :compiler {
                :output-to "app.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}
             {:id "release"
              :source-paths ["src"]
              :compiler {
                :output-to "app.js"
                :optimizations :advanced
                :elide-asserts true
                :pretty-print false
                :output-wrapper false
                :preamble ["react/react.min.js"]
                :externs ["react/externs/react.js"]}}]})
