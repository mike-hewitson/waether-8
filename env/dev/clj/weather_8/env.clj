(ns weather-8.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [weather-8.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[weather-8 started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[weather-8 has shut down successfully]=-"))
   :middleware wrap-dev})
