(ns perpend.crc)


;; CRC32C
;;
;;

;; Using java.util.zip's CRC32 implementation:
(defn ref-crc32 [s]
  (let [crc (new java.util.zip.CRC32)
	bytes-array (.getBytes s)]
    (do
      (.update crc bytes-array 0 (count bytes-array))
      (.getValue crc))))

;; reverse polynomial
(def crc32-polynomial 0xEDB88320)
(def max-int 0xFFFFFFFF)

(defn crc32-loop-8-bits [crc]
  (loop [j 8
         tmp crc]
    (if (zero? j)
      tmp
      (if (= (bit-and tmp 1) 1)
        (recur (dec j) (bit-xor (unsigned-bit-shift-right tmp 1) crc32-polynomial))
        (recur (dec j) (unsigned-bit-shift-right tmp 1))))))

(defn crc32-inner [crc ch]
  (let [tmp (crc32-loop-8-bits (bit-and (bit-xor crc ch) 0xff))]
    (bit-xor (unsigned-bit-shift-right crc 8) tmp)))

(defn crc32 [s]
  (let [bytes (.getBytes s)
        crc (reduce crc32-inner 0xFFFFFFFF bytes)]
    ;; flip bits
    (bit-xor crc 0xffffffff)))
