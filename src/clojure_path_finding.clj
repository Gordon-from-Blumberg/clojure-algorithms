(ns clojure-path-finding
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(println (macroexpand '(->> (io/reader file)
                            (line-seq)
                            (map #(clojure.string/split % #" "))
                            (map #([(set (subvec % 0 2))
                                    (get % 2)]))
                            )
                      ))

(defn read-graph [file] (->> (io/reader file)
                             (line-seq)
                             (map #(clojure.string/split % #" "))
                             (map #([(set (subvec % 0 2))
                                     (get % 2)]))
                             )
  )

(println (read-graph "test.txt"))

         ;(let [graph ()])