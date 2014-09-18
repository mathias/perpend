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

(defn crc32 [s]
  s)
