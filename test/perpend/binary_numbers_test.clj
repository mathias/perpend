(ns perpend.binary-numbers-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]))

(deftest representing-binary-numbers-tests
  (fact (= 2r011 3)) => truthy
  (fact (str 2r011) => "3")
  (fact (int 2r11010011101100) => 13548))

(deftest binary-division-tests
  (fact
    (/ 2r1100 2r10)
    =>
    2r110)
  (fact "remainders"
    (/ 2r1011 2r11)
    =>
    11/3))

(deftest xor-tests
  (fact (bit-xor 0 0) => 0)
  (fact (bit-xor 0 1) => 1)
  (fact (bit-xor 1 1) => 0)
  (fact (bit-xor 1 0) => 1)

  ;; Used as part of division of longer numbers, digits are XORed:
  (fact (bit-xor 2r1101 2r1011) => 2r0110))
