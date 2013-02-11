(ns esclojure.action.ClojureFibonacciResponse
  (:gen-class :extends org.elasticsearch.action.ActionResponse
              :contructors {[] []
                            [String] []}
              :state state
              :init init))

(defn -init
  ([]
     [[] (atom nil)])
  ([ack]
     [[] (atom (boolean ack))]))

(defn -readFrom [this in]
  (reset! (.state this) (.readBoolean in)))

(defn -writeTo [this out]
  (.writeBoolean out (boolean @(.state this))))
