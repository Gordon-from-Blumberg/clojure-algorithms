(ns clojure-path-finding
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(println "Hello world" (reduce + (range 1 11)))

(println (macroexpand '(->> (io/reader "test.txt")
                           (line-seq)
                           (map #(str/split % #" "))
                           )))
(println (->> (io/reader "test.txt")
              (line-seq)
              (map #(clojure.string/split % #" "))))