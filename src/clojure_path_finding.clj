(ns clojure-path-finding
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

;(println (macroexpand '(->> (io/reader file)
;                            (line-seq)
;                            (map #(clojure.string/split % #" "))
;                            (map #([(set (subvec % 0 2))
;                                    (get % 2)]))
;                            )
;                      ))

;(defn read-graph [file] (let [lines (line-seq (io/reader file))] {
;                                                                  [:number :target] (str/split (first lines) " ")
;                                                                  :points
;                                                                  }
;                          )
;)

(defn read-graph [file]
  (let [lines (->> (io/reader file)
                   (line-seq))
        size-tar (-> (first lines)
                    (str/split #" "))] {
                                        :size   (get size-tar 0)
                                        :target (get size-tar 1)
                                        :points (->> (rest lines)
                                                     (map #(str/split % #" "))
                                                     (map #(vector (set (subvec % 0 2))
                                                                   (get % 2))))
                                        }

  ))

(println (read-graph "test.txt"))

(println (map #(vector (set (subvec % 0 2))
                       (get % 2)) '([1 2 2] [1 3 1])))

(let [gr (read-graph "test.txt")] (println (:size gr) (:target gr)))

         ;(let [graph ()])