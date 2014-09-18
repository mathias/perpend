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

(defn crc32-table-inner [i]
  (loop [j 8
         rem i]
    (if (zero? j)
      rem
      (if (bit-and rem 1)
        (recur (dec j) (bit-xor 0xEDB88320 (bit-shift-right 1 rem)))
        (recur (dec j) (bit-shift-right 1 rem))))))

(def crc32-lookup-table
  (map crc32-table-inner (range 256)))

(defn crc32 [s]
  (let [polynomial 0x04C11DB7])
  s)
