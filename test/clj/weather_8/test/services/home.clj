(ns weather-8.test.services.home
  (:require [clojure.test :as t :refer [is deftest testing]]
            [weather-8.services.home :as sut]
            [weather-8.test.fixtures :as fix]))

(deftest translate-direction-should-return-correct-direction
  (is (= (sut/translate-direction 0) "Northerly"))
  (is (= (sut/translate-direction 45) "North-easterly"))
  (is (= (sut/translate-direction 44.9) "North-easterly"))
  (is (= (sut/translate-direction 50) "North-easterly"))
  (is (= (sut/translate-direction 359) "Northerly")))

#_(facts "about 'format-readings-for-merge'"
       (let [readings (r/format-readings-for-merge fix/latest-reading)]
         (fact "it should return a map"
               (map? readings) => true)
         (fact "it should contain 3 items"
               (count readings) => 3)
         (fact "elements should contain 10 items"
               (count (val (first readings))) => 10)))

#_(facts "about 'create-directions-for-merge'"
       (let [directions (r/create-directions-for-merge fix/latest-reading)]
         (fact "it should return a map"
               (map? directions) => true)
         (fact "it should contain 3 items"
               (count directions) => 3)
         (fact "elements should contain 1 items"
               (count (val (first directions))) => 1)
         (fact "it should contain wind-direction"
               (:wind-direction (val (first directions))) => truthy)
         (fact "it should contain some correct data"
               (string? (:wind-direction (val (first directions)))) => true)))

; TODO weird bug - function does t/after? does not work when tested

; (facts "about 'create-tide-for-merge'"
;   (let [tides (r/create-tide-for-merge fix/tides-data)]
;     (fact "it should return a map"
;      (map? tides) => true)
;     (fact "it should contain 2 items"
;      (count tides) => 2)
;     (fact "elements should contain 4 items"
;      (count (val (first tides))) => 4)
;     (fact "it should contain a date field"
;       (:date (val (first tides))) => truthy)
;     (fact "it should contain some correct data"
;       (string? (:type (val (first tides)))) => true)))
