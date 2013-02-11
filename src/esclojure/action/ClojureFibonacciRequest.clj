(ns esclojure.action.ClojureFibonacciRequest
  (:require [esclojure.fibonacci :as fib])
  (:gen-class
   :extends org.elasticsearch.action.support.nodes.NodesOperationRequest
   :contructors {[] []}))

