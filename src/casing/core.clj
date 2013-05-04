(ns casing.core)
 
(defn camel-to-lisp-case [s]
  (let [uppers (set
                (map char
                     (range 65 91)))
        lowers (map #(str "-" %)
                    (map char
                         (range 97 123)))
        replacement (replace
                     (zipmap uppers lowers)
                     (vec s))]
    (->> replacement
         rest
         (cons (-> s first str .toLowerCase))
         (apply str))))

(defn casing [s] (camel-to-lisp-case s))
