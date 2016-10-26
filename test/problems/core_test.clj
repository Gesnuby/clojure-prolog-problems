(ns problems.core-test
  (:require [clojure.test :refer :all]
            [problems.core :refer :all]))

(deftest p1-test
  (testing "Find last element of empty list"
    (is (= nil (p1 []))))
  (testing "Find last element of a list"
    (is (= 5 (p1 [1 2 3 4 5])))))

(deftest p2-test
  (testing "Find the last but one element of empty list"
    (is (= nil (p2 []))))
  (testing "Find the last but one element of non-empty list"
    (is (= 4 (p2 [1 2 3 4 5])))))

(deftest p3-test
  (testing "Find the 2nd element of empty list"
    (is (thrown? IndexOutOfBoundsException (p3 2 []))))
  (testing "Find the 3rd element of non-empty list"
    (is (= "a" (p3 3 ["b" "c" "a" "d"]))))
  (testing "Find the -2nd element of non-empty list"
    (is (thrown? IndexOutOfBoundsException (p3 -2 [1 2 3])))))

(deftest p4-test
  (testing "Find the number of elements of empty list"
    (is (= 0 (p4 []))))
  (testing "Find the number of elements of non-empty ylist"
    (is (= 3 (p4 [1 2 3])))))

(deftest p5-test
  (testing "Reverse empty list"
    (is (empty? (p5 []))))
  (testing "Reverse non-empty list"
    (is (= [1 2 3] (p5 [3 2 1])))))

(deftest p6-test
  (testing "Check if empty list is a palindrome"
    (is (true? (p6 []))))
  (testing "Check if [1 2 3] is a palindrome"
    (is (false? (p6 [1 2 3]))))
  (testing "Check if [1 2 3 2 1] is a palindrome"
    (is (true? (p6 [1 2 3 2 1])))))

(deftest p7-test
  (testing "Flatten [1 2 [3 [4 5 [6 [7]] list"
    (is (= [1 2 3 4 5 6 7] (p7 [1 2 [3 [4 5 [6 [7]]]]]))))
  (testing "Flatten [1 2 3] list"
    (is (= [1 2 3] (p7 [1 2 3])))))

(deftest p8-test
  (testing "Eliminate consecutive duplicate: [1 1 2 2 1 3 3 4] must be [1 2 1 3 4]"
    (is (= [1 2 1 3 4] (p8 [1 1 2 2 1 3 3 4])))))

(deftest p9-test
  (testing "Packing consecutive duplicates into sublists: [1 1 2 2 1 3 3 4] must be [[1 1] [2 2] [1] [3 3] [4]]"
    (is (= '((1 1) (2 2) (1) (3 3) (4)) (p9 '(1 1 2 2 1 3 3 4)))))
  (testing "Packing consecutive duplicates into sublists: [1 2 3 4] must be [[1] [2] [3] [4]]"
    (is (= '((1) (2) (3) (4)) (p9 '(1 2 3 4)))))
  (testing "Packing consecutive duplicates into sublists: [] must be []"
    (is (= '() (p9 '())))))

(deftest p10-test
  (testing "Running length encoding of a list: [a a b a d d d e] must be [[2 a] [1 b] [1 a] [3 d] [1 e]]"
    (is (= '((2 "a") (1 "b") (1 "a") (3 "d") (1 "e")) (p10 '("a" "a" "b" "a" "d" "d" "d" "e"))))))

(deftest p11-test
  (testing "Modified run-length encoding: [a a b a d d d e] must be [[2 a] b a [3 d] e]"
    (is (= '((2 "a") "b" "a" (3 "d") "e") (p11 '("a" "a" "b" "a" "d" "d" "d" "e")))))
  (testing "Modified run-length encoding: [a b c d] must be [a b c d]"
    (is (= '("a" "b" "c" "d") (p11 '("a" "b" "c" "d"))))))

(deftest p12-test
  (testing "Decode a run-length encoded list: [[2 a] b [3 c] d] must be [a a b c c c d]"
    (is (= '("a" "a" "b" "c" "c" "c" "d") (p12 '((2 "a") "b" (3 "c") "d")))))
  (testing "Decode a run-length encoded list: [a b c d] must be [a b c d]"
    (is (= '("a" "b" "c" "d") (p12 '("a" "b" "c" "d"))))))

(run-all-tests)