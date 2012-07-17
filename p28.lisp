(defun diagonals-sum (side-length)
	(setq adjusted-side (+ side-length 2))
	(let* ((n 1) (current 1) (total 1))
		(loop
			
			(dotimes (number 4 value)
				(setq current (+ (* n 2) current))
				(setq total (+ total current))
				(setq value current)
				(print value)
				(print total))
			(incf n)
			(when (= (+ 1 (* n 2)) adjusted-side) (return)))))
