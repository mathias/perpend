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

;; Using java.util.zip's Adler32 implementation:
(defn ref-adler-32 [s]
  (let [adler32 (new java.util.zip.Adler32)
        bytes-array (.getBytes s)]
    (do
      (.update adler32 bytes-array 0 (count bytes-array))
      (.getValue adler32))))

;; Fletcher-32

(defn fletcher-32-reducer [[a b] ch]
  (let [n (int ch)
        new-a (mod (+ a n) 65535)
        new-b (mod (+ b new-a) 65535)]
    [new-a new-b]))

(defn fletcher-32 [s]
  (let [[a b] (reduce fletcher-32-reducer [0 0] s)]
    (bit-or (bit-shift-left b 16) a)))
