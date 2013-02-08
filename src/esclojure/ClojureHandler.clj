(ns esclojure.ClojureHandler
  (:require [clojure.tools.logging :as log])
  (:gen-class :name esclojure.ClojureHandler
              :extends org.elasticsearch.common.component.AbstractComponent
              :constructors {^{org.elasticsearch.common.inject.Inject true}
                             [org.elasticsearch.common.settings.Settings]
                             [org.elasticsearch.common.settings.Settings]}
              :init init))

(defn -init [settings]
  (log/info "init-handler!")
  [[settings] nil])

(defn -initialize [this]
  (log/info "initialize!"))

