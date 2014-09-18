(ns perpend.crc-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [perpend.crc :refer :all]))


;; CRC32C

;; values from Java reference implementation:
(deftest ref-crc32-tests
  (fact (ref-crc32 "abcde") => 2240272485))



