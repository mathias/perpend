(ns perpend.checksums-test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [perpend.checksums :refer :all]))


;; Adler-32
(deftest adler-32-fn-tests
  (fact (adler-32 "Wikipedia") => 300286872)
  (fact (adler-32 "") => 1))
