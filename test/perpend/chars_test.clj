(ns perpend.chars_test
  (:require [midje.sweet :refer :all]
            [clojure.test :refer :all]
            [perpend.chars :refer :all]))

(deftest char-to-int-fn-tests
  (fact "ASCII characters are converted"
    (char-to-int \A) => 65
    (char-to-int \B) => 66))

(deftest string-to-ints-fn-tests
  (fact (string-to-ints "AB") => [65 66]))
