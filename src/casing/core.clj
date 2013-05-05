(ns casing.core
  (:require [clojure.string :as string]))

(defn- camel-to-lisp-case [s]
  (let [camel-caps (re-seq #"[A-Z]{1}[a-z]{1}" s)
        case-camel-caps (map #(apply str "-" %)
                             camel-caps)
        remove-camel (loop [_ [s]
                            rm (zipmap
                                camel-caps
                                case-camel-caps)]
                       (if-not (seq rm)
                         (last _)
                         (let [this (-> rm keys first)
                               that (-> rm vals first string/lower-case)]
                           (recur
                            (conj _
                                  (.. (last _)
                                      (replace this that)))
                            (rest rm)))))
        up-to-low (loop [_ [remove-camel]
                         up (re-seq #"[A-Z]+"
                                    remove-camel)]
                    (if-not (seq up)
                      (last _)
                      (let [this (first up)
                            that (string/lower-case 
                                  (str "-" (first up) "-"))]
                        (recur
                         (conj _
                               (.. (last _)
                                   (replace this that)))
                         (rest up)))))
        lisp-case (->> (.. up-to-low
                           (replace "--" "-"))
                       (#(if-not (= (last %) \-)  % (drop-last %)))
                       rest
                       (apply str))]
    lisp-case))

(defn casing [s] (camel-to-lisp-case s))
        
