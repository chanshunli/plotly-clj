;; gorilla-repl.fileformat = 1

;; **
;;; #Scatter-3d
;; **

;; @@
(ns bar
  (:require [clojure.core.matrix :as m]
            [clojure.core.matrix.dataset :as d]
            [clojure.core.matrix.random :as rnd]
            [clojure.data.csv :as csv])
  (:use [plotly-clj.core] :reload-all))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(online-init)
;; @@
;; =>
;;; {"type":"html","content":"<script src=\"https://cdn.plot.ly/plotly-latest.min.js\" type=\"text/javascript\"></script>","value":"pr'ed value"}
;; <=

;; @@
(let [steps (range 0 20 0.1)]
  (-> (plotly)
      (add-scatter-3d :x (m/sin steps) :y (m/cos steps) :z steps :mode "lines")
      (plot "simple lines 3d" :fileopt "overwrite")
      embed-url))
;; @@
;; =>
;;; {"type":"html","content":"<iframe height=\"600\" src=\"//plot.ly/~findmyway/132.embed\" width=\"800\"></iframe>","value":"pr'ed value"}
;; <=

;; @@
(def data 
  (let [in-file (slurp "https://raw.githubusercontent.com/plotly/datasets/master/3d-scatter.csv")
        data (doall (csv/read-csv in-file))]
    (d/dataset (map keyword (first data)) (rest data))
  ))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;bar/data</span>","value":"#'bar/data"}
;; <=

;; @@
(-> (plotly data)
    (add-scatter-3d :x :x1 :y :y1 :z :z1 :mode "markers"
                    :marker {:size 12
                             :opacity 0.8
                             :line {:color "rgba(217, 217, 217, 0.14)" :width 0.5}})
    (plot "simple scatter 3d" :fileopt "overwrite")
    embed-url)
;; @@
;; =>
;;; {"type":"html","content":"<iframe height=\"600\" src=\"//plot.ly/~findmyway/92.embed\" width=\"800\"></iframe>","value":"pr'ed value"}
;; <=
