(ns perpend.chars)

;; Understand how chars to ints work, and plan how to use this in
;; various functions that will need to treat strings as arrays of ints.

(defn char-to-int [c]
  (int c))

(defn string-to-ints [s]
  (map char-to-int s))
