(ns perpend.checksums-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [perpend.checksums :refer :all]))


;; Adler-32
(deftest adler-32-fn-tests
  (fact (adler-32 "Wikipedia") => 300286872)
  (fact (adler-32 "") => 1))

;; Test the we get the same values from the Java reference implementation:


(deftest adler32-class-tests
  (fact (ref-adler-32 "Wikipedia") => 300286872)
  (fact (ref-adler-32 "") => 1))

(deftest test-against-reference
  (fact (adler-32 "abcde") => (ref-adler-32 "abcde")))

;; Fletcher-32
(deftest fletcher-32-fn-tests
  (fact (fletcher-32 "abcde") => 96666095)
  (fact (fletcher-32 "a") => 6357089))

