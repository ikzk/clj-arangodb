(ns clj-arangodb.arangodb.aql
  (:require
   [clj-arangodb.velocypack.core :as v])
  (:import com.arangodb.velocypack.VPackSlice))

(defn query
  "https://docs.arangodb.com/3.0/AQL/Fundamentals/BindParameters.html"
  [db query-string binding-map]
  (map v/unpack*
       (.asListRemaining (.query db query-string
                                 (java.util.HashMap. binding-map)
                                 nil VPackSlice))))
