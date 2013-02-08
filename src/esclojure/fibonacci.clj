(ns esclojure.fibonacci)

(defn fibonacci
  ([n]
     (let [num (try (Integer/parseInt n) (catch Exception _ 10))]
       (fibonacci [0 1] num)))
  ([x n]
     (if (< (count x) n)
       (recur (conj x (+ (last x) (nth x (- (count x) 2)))) n)
       x)))
