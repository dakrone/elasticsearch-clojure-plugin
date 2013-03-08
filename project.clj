(defproject elasticsearch-clojure "0.1.0"
  :description "An example Elasticsearch plugin written entirely in Clojure"
  :url "https://github.com/dakrone/elasticsearch-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [org.clojure/tools.logging "0.1.2"]
                 [org.elasticsearch/elasticsearch "0.20.5"]]
  :aot [esclojure.ClojureHandler
        esclojure.ClojureModule
        esclojure.action.ClojureFibonacciRequest
        esclojure.action.ClojureFibonacciResponse
        esclojure.action.TransportClojureFibonacciAction
        esclojure.rest.action.RestClojureFibonacciAction
        esclojure.ClojurePlugin]
  :aliases {"es" ["do" "clean,"
                  "compile,"
                  "run" "-m" "org.elasticsearch.bootstrap.ElasticSearch"]})
