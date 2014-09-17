(ns perpend.checksums)


;; Adler-32

;; An Adler-32 checksum is obtained by calculating two 16-bit checksums A and B
;; and concatenating their bits into a 32-bit integer.
;; A is the sum of all bytes in the stream plus one.
;; B is the sum of the individual values of A from each step.
;; Adler-32(D) = B × 65536 + A

(defn adler-checksum-reducer [[a b] ch]
  [(+ a (int ch))
   (+ a b (int ch))])

(defn adler-32 [s]
  (let [prime 65521
        [a b] (reduce adler-checksum-reducer [1 0] s)]
    (+ (* (mod b prime) 65536)
       (mod a prime))))
