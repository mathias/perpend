(ns perpend.crc-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [perpend.crc :refer :all]))


;; CRC32C

;; values from Java reference implementation:
(deftest ref-crc32-tests
  (fact (ref-crc32 "abcde") => 2240272485))

;; values come from the C implementation in the src/ dir
(deftest crc32-tests
  (let [quick "The quick brown fox jumps over the lazy dog"
        expected-hex 0x414FA339]
    (fact (crc32 quick) => expected-hex)))


