(ns weather-8.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[weather-8 started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[weather-8 has shut down successfully]=-"))
   :middleware identity})
