(ns perpend.crc-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [perpend.crc :refer :all]))


;; CRC32C

;; values from Java reference implementation:
(deftest ref-crc32-tests
  (fact (ref-crc32 "abcde") => 2240272485))

;; values come from the Java & C implementation in the src/ dir
(deftest crc32-tests
  (facts "Matches expected hex"
    (let [quick "The quick brown fox jumps over the lazy dog"
          quick-expected 0x414FA339
          simple "a"
          simple-expected 0xE8B7BE43]
      (fact (crc32 simple) => simple-expected)
      (fact (crc32 quick) => quick-expected))))
