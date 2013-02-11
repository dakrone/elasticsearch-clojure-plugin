(ns esclojure.action.TransportClojureFibonacciAction
  (:require [clojure.tools.logging :as log])
  (:import (esclojure.action ClojureFibonacciRequest ClojureFibonacciResponse)
           (org.elasticsearch.threadpool ThreadPool$Names))
  (:gen-class
   :extends
   org.elasticsearch.action.support.master.TransportMasterNodeOperationAction
   :constructors {^{org.elasticsearch.common.inject.Inject true}
                  [org.elasticsearch.common.settings.Settings
                   org.elasticsearch.transport.TransportService
                   org.elasticsearch.cluster.ClusterService
                   org.elasticsearch.threadpool.ThreadPool]
                  [org.elasticsearch.common.settings.Settings
                   org.elasticsearch.transport.TransportService
                   org.elasticsearch.cluster.ClusterService
                   org.elasticsearch.threadpool.ThreadPool]}
   :init init
   :state state))

(defn -init [settings transport-serv cluster-serv thread-pool]
  (log/info "init of TransportClojureFibonacciAction!")
  [[settings transport-serv cluster-serv thread-pool] (atom nil)])

(defn -transportAction [this]
  "/clojure/fibonacci")

(defn -executor [this]
  ThreadPool$Names/CACHE)

(defn -newRequest [this]
  (ClojureFibonacciRequest.))

(defn -newResponse [this]
  (ClojureFibonacciResponse.))

(defn -masterOperation [this request cluster-state]
  (ClojureFibonacciResponse.))
