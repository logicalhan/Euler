(defn triangle [n]
  (/ (* n (+ n 1)) 2))

(defn pentagonal [n]
  (/ (* n (- (* n 3) 1)) 2))

(defn hexagonal [n]
  (* n (- (* n 2) 1)))

(defn loop-through-p [i target]
  (loop [pi i p (pentagonal pi)]
    (if (= p target)
      true
      (if (> p target)
          false
          (recur (+ pi 1) (pentagonal (+ pi 1)))))))
(defn loop-through-t [i target]
  (loop [pi i p (triangle pi)]
    (if (= p target)
      true
  (if (> p target)
      false
      (recur (+ pi 1) (triangle (+ pi 1)))))))

(defn pindexgrabber [i target]
  (loop [pi i p (pentagonal pi)]
    (if (= p target)
      pi
      (if (> p target)
          (- pi 1)
          (recur (+ pi 1) (pentagonal (+ pi 1)))))))
(defn tindexgrabber [i target]
  (loop [pi i p (triangle pi)]
    (if (= p target)
      pi
      (if (> p target)
          (- pi 1)
          (recur (+ pi 1) (triangle (+ pi 1)))))))


(loop [hindex 144 pindex 166 tindex 286 target (hexagonal hindex)]
  (if-not (loop-through-p pindex target)
    (recur (+ hindex 1) (pindexgrabber pindex target) (pindexgrabber pindex target) (hexagonal (+ hindex 1)))
    (if-not (loop-through-t tindex target)
    (recur (+ hindex 1) (pindexgrabber pindex target) (tindexgrabber tindex target) (hexagonal (+ hindex 1)))
      (println target))))
