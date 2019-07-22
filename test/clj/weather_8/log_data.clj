(ns weather-8.test.log-data
  (:require [clojure.test :as t :refer [is deftest testing]]
            [weather-8.log-data :as sut]
            [weather-8.test.fixtures :as fix]))

(deftest get-darksky-reading-should-return-data
       (let [reading (sut/get-darksky-data "51.317,0.057")]
         (is  (map? reading))
         (is  (map? (:currently reading)))
         (is  (map? (:currently reading)))
         (is  (map? (:daily reading)))))

#_(facts "about 'extract-reading-data'"
       (let [reading-data (sut/extract-reading-data fix/a-darksky-reading-body)]
         (fact "it should return a cmap"
               (map? reading-data) => true)
         (fact "it should return the correct data"
               (get reading-data ["day-summary"]) => "Foggy in the evening."
               (get reading-data ["now-summary"]) => "Partly Cloudy")))

#_(facts "about 'create-update'"
       (let [update (sut/create-update "London"
                                   (extract-reading-data
                                    fix/a-darksky-reading-body))]
         (fact "it should return a map"
               (map? update) => true)
         (fact "it should contain 14 items"
               (count update) => 17)
         (fact "it should contain some correct data"
               (:sunrise update))) => true
       (:icon update)) => true
