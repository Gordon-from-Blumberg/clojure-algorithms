(ns clojure-path-finding
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defn get-int [coll index]
  (Integer/parseInt (get coll index)))

(defn int-set [coll]
  (->> (set coll)
       (map #(Integer/parseInt %))
       set))

(defn read-graph [file]
  (let [lines (->> (io/reader file)
                   line-seq)
        size-tar (-> (first lines)
                    (str/split #" "))] {
                                        :size   (get-int size-tar 0)
                                        :target (get-int size-tar 1)
                                        :points (->> (rest lines)
                                                     (map #(str/split % #" "))
                                                     (map #(vector (int-set (subvec % 0 2))
                                                                   (get-int % 2))))
                                        }

  ))

(defn siblings [graph point]
  (println "point =" point)
  (->> (:points graph)
       (map #(get % 0))
       (filter #(contains? % point))
       (map #(-> (disj % point)
                 first))
       ))

(def graph (read-graph "test.txt"))

(println graph)

(println (last (siblings graph 12) ))