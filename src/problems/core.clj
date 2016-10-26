(ns problems.core)

(defn p1
  "1.01 Finds last element of the list"
  [list]
  (last list))

(defn p2
  "1.02 Find the last but one element of a list"
  [list]
  (last (butlast list)))

(defn p3
  "1.03 Find the K'th element of a list"
  [n list]
  (nth list (- n 1)))

(defn p4
  "1.04 Find the number of elements of a list"
  [list]
  (count list))

(defn p5
  "1.05 Reverse a list"
  [list]
  (reverse list))

(defn p6
  "1.06 Find out whether a list is a palindrome"
  [list]
  (= list (reverse list)))

(defn p7
  "1.07 Flatten a nested list structure"
  [list]
  (flatten list))

(defn p8
  "1.08 Eliminate consecutive duplicates of list elements
  [a,a,a,a,b,c,c,a,a,d,e,e,e,e] should be [a,b,c,a,d,e]"
  [list]
  (dedupe list))

(defn p9
  "1.09 Pack consecutive duplicates of list elements into sublists
  [a,a,a,a,b,c,c,a,a,d,e,e,e,e] should be [[a,a,a,a],[b],[c,c],[a,a],[d],[e,e,e,e]]"
  [values]
  (reverse (reduce (fn [a b]
                     (if (empty? a)
                       (list (list b))
                       (if (= b (first (first a)))
                         (conj (rest a) (conj (first a) b))
                         (conj a (list b)))))
                   '()
                   values)))

(defn p10
  "1.10 Run-length encoding of a list
  [a a b a d d d e] should be [[2 a] [1 b] [1 a] [3 d] [1 e]]"
  [values]
  (let [packed (p9 values)]
    (reverse (reduce (fn [a b]
                       (if (empty? a)
                         (list (list (count b) (first b)))
                         (conj a (list (count b) (first b)))))
                     '()
                     packed))))

(defn p11
  "1.11 Modified run-length encoding
  [a a b a d d d e] should be [[2 a] b a [3 d] e]"
  [values]
  (let [encoded (p10 values)]
    (reverse (reduce (fn [a b]
                       (if (= 1 (first b))
                         (conj a (last b))
                         (conj a b)))
                     '()
                     encoded))))

(defn p12
  "1.12 Decode a run-length encoded list
  [[2 a] b a [3 d] e] should be [a a b a d d d e]"
  [encoded]
  (flatten (reverse (reduce (fn [a b]
                              (if (seq? b)
                                (conj a (repeat (first b) (last b)))
                                (conj a b)))
                            '()
                            encoded))))

(defn p13
  "1.13 Run-length encoding of a list (direct solution)"
  [values]
  (reduce (fn [a b]
            (if (empty? a)
              (list b)
              (if (seq? (first a))
                (conj (rest a) (list (list (+ (first (first a)) 1) b)))
                (if (= (first a) b)
                  (conj (rest a) '(2 b))
                  (conj a b)))))
          '()
          values))
