(ns perpend.checksums-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [perpend.checksums :refer :all]))


;; Adler-32
(deftest adler-32-fn-tests
  (fact (adler-32 "Wikipedia") => 300286872)
  (fact (adler-32 "") => 1))

;; Fletcher-32
(deftest fletcher-32-fn-tests
  (fact (fletcher-32 "abcde") => 96666095)
  (fact (fletcher-32 "a") => 6357089))


;; (deftest md5-fn-tests
;;  (fact (md5 "The quick brown fox jumped over the lazy dog's back") => "e38ca1d920c4b8b8d3946b2c72f01680"))
