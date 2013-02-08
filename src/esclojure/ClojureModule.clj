(ns esclojure.ClojureModule
  (:require [clojure.tools.logging :as log])
  (:import (esclojure ClojureHandler))
  (:gen-class :extends org.elasticsearch.common.inject.AbstractModule))

(defn -configure [this]
  (log/info "configure!")
  (.asEagerSingleton (.bind this ClojureHandler))
  (log/info "done-configure!"))
