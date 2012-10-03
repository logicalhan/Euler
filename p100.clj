;; currently too slow
(defn disc-percentage-for-two [blue-discs total-discs]
  (* (double (/ blue-discs total-discs))
     (double (/ (- blue-discs 1) (- total-discs 1)))))
(defn valid-blue-number [bluediscs totaldiscs]
	(if (= (disc-percentage-for-two  bluediscs totaldiscs) 0.5)
      (println "valid")
      (disc-percentage-for-two  bluediscs totaldiscs)))
(valid-blue-number 15 22)

(defn find-next-valid [bcount tcount]
    (loop [b bcount t tcount]
   	(if (= (disc-percentage-for-two b t) 0.5)
      {(println b) (println t)})
    (if (< (disc-percentage-for-two b t) 0.5)
      (recur (+ b 1) t)
    	(if (> (disc-percentage-for-two b t) 0.5)
      	(recur b (+ t 1))))))

(find-next-valid 700000000000 1000000000000)