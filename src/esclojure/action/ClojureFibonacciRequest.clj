(ns esclojure.action.ClojureFibonacciRequest
  (:gen-class
   :extends org.elasticsearch.action.support.master.MasterNodeOperationRequest
   :contructors {[String] []}))

(defn -validate [this]
  nil)
