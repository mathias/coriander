(set-env!
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure       "1.6.0"       :scope "provided"]
                  [gorilla-repl              "0.3.4"       :scope "provided"]
                  [ns-tracker                "0.2.2"]
                  [adzerk/bootlaces          "0.1.5"       :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[boot.task.built-in :as task]
         '[boot.pod           :as pod])

(def +version+ "0.0.1")

(bootlaces! +version+)

(task-options!
 pom  {:project     'coriander
       :version     +version+
       :description "Working with Gorilla REPL and ???"
       :url         "https://github.com/mathias/coriander"
       :scm         {:url "https://github.com/mathias/coriander"}
       :license     {:name "Eclipse Public License"
                     :url  "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask gorilla
  "Run a Gorilla REPL."
  [p port       PORT int "The port to run the web REPL on. Defaults to 4000."
   i ip         IP   str "The IP address the server listens on. Defaults to 127.0.0.1"
   n nrepl-port PORT int "The port that the nREPL server will be started up on. Defaults to a free port."
   b block           bool "Blocking (for standalone use)"]
  (let [worker     (pod/make-pod (get-env))
        ip         (or ip "127.0.01")
        port       (or port 4000)
        nrepl-port (or nrepl-port 0)
        block      (or block false)]
    (comp
     (with-pre-wrap fileset
       (pod/with-eval-in worker
         (require '[gorilla-repl.core :as g])
         (g/run-gorilla-server {:port ~port
                                :ip ~ip
                                :nrepl-port ~nrepl-port
                                :project "Coriander"})
         (util/info "<< started Gorilla REPL on http://localhost:%d >>\n" ~port))
       fileset)
     (if block
       (task/wait)
       identity))))
