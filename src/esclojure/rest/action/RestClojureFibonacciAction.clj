(ns esclojure.rest.action.RestClojureFibonacciAction
  (:require [clojure.tools.logging :as log]
            [esclojure.fibonacci :as fib])
  (:import (esclojure.action ClojureFibonacciRequest)
           (org.elasticsearch.action ActionListener)
           (org.elasticsearch.rest RestStatus RestRequest$Method)
           (org.elasticsearch.rest.action.support RestXContentBuilder)
           (org.elasticsearch.rest XContentRestResponse))
  (:gen-class :extends org.elasticsearch.rest.BaseRestHandler
              :constructors {^{org.elasticsearch.common.inject.Inject true}
                             [org.elasticsearch.common.settings.Settings
                              org.elasticsearch.client.Client
                              org.elasticsearch.rest.RestController
                              esclojure.action.TransportClojureFibonacciAction]
                             [org.elasticsearch.common.settings.Settings
                              org.elasticsearch.client.Client]}
              :init init
              :post-init post-init
              :state state))

(defn -init [settings client controller fibonacci-action]
  (log/info "init of esclojure.rest.action.RestClojureFibonacciAction!")
  (let [state (atom {:fib-action fibonacci-action})]
    [[settings client] state]))

(defn -post-init [this settings client controller fibonacci-action]
  (log/info "post-init!")
  (.registerHandler controller RestRequest$Method/GET "/_fibonacci" this))

(defn -handleRequest [this request channel]
  ;; For some reason, these log methods don't actually work
  (log/info "handleRequest!")
  (let [state (.state this)
        _ (log/info "state:" state)
        fib-request (:fib-action state)
        builder (RestXContentBuilder/restContentBuilder request)]
    (log/info "req:" fib-request)
    (.startObject builder)
    (.field builder "fibonacci" (fib/fibonacci (.param request "num")))
    (.endObject builder)
    (.sendResponse channel
                   (XContentRestResponse. request
                                          RestStatus/OK builder))))
