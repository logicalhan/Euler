(defn triangle [n]
  (/ (* n (+ n 1)) 2))

(defn pentagonal [n]
  (/ (* n (- (* n 3) 1)) 2))

(defn hexagonal [n]
  (* n (- (* n 2) 1)))

(defn loop-through [tph]
  (let [thisfunction tph]
    (fn [i target]
      (loop [pi i p (thisfunction pi)]
      (if (= p target)
            true
        (if (> p target)
            false
            (recur (+ pi 1) (thisfunction (+ pi 1)))))))))

(defn indexgrabber [funct]
  (let [thisfunct funct]
      (fn [i target]
    (loop [pi i p (thisfunct pi)]
        (if (= p target)
          pi
          (if (> p target)
              (- pi 1)
              (recur (+ pi 1) (thisfunct (+ pi 1)))))))))
(def ltp (loop-through pentagonal))
(def ltt (loop-through triangle))
(def pindexgrabber (indexgrabber pentagonal))
(def tindexgrabber (indexgrabber triangle))

(loop [hindex 144 pindex 166 tindex 286 target (hexagonal hindex)]
  (if-not (ltp pindex target)
    (recur (+ hindex 1) (pindexgrabber pindex target) (pindexgrabber pindex target) (hexagonal (+ hindex 1)))
    (if-not (ltt tindex target)
    (recur (+ hindex 1) (pindexgrabber pindex target) (tindexgrabber tindex target) (hexagonal (+ hindex 1)))
      (println target))))