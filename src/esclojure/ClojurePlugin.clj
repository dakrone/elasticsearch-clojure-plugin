(ns esclojure.ClojurePlugin
  (:require [clojure.tools.logging :as log])
  (:import (java.util ArrayList)
           (esclojure ClojureModule)
           (org.elasticsearch.common.settings ImmutableSettings$Builder))
  (:gen-class :extends org.elasticsearch.plugins.AbstractPlugin
              :constructors {[org.elasticsearch.common.settings.Settings] []}
              :init init
              :state s))

(defn -init [settings]
  (log/info "init!")
  [[] (atom nil)])

(defn -name [this]
  (log/info "name!")
  "clojureplugin")

(defn -description [this]
  (log/info "description!")
  (println :description)
  "An example Elasticsearch plugin in Clojure")

(defn ^org.elasticsearch.common.settings.Settings -additionalSettings
  [this]
  (log/info "additionalSettings!")
  ImmutableSettings$Builder/EMPTY_SETTINGS)

(defn -modules
  ([this]
     (log/info "modules!")
     (ArrayList. [(Class/forName "esclojure.ClojureModule")]))
  ([this settings]
     (log/info "modules with settings!")
     (ArrayList.)))

(defn -processModule [this module]
  (when (instance? org.elasticsearch.rest.RestModule module)
    (log/info "processModule!")
    (.addRestAction module esclojure.rest.action.RestClojureFibonacciAction)))
