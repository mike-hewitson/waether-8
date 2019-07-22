(ns weather-8.app
  (:require [weather-8.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
