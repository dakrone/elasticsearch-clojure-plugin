(ns esclojure.rest.action.RestClojureFibonacciAction
  (:require [clojure.tools.logging :as log]
            [esclojure.fibonacci :as fib])
  (:import (org.elasticsearch.rest RestStatus RestRequest$Method)
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
  (let [builder (RestXContentBuilder/restContentBuilder request)
        state (.state this)]
    (.startObject builder)
    (.field builder "fibonacci" (fib/fibonacci (.param request "num")))
    (.field builder "state" (str @state))
    (.endObject builder)
    (.sendResponse channel (XContentRestResponse. request
                                                  RestStatus/OK builder))))
