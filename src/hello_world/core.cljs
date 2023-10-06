(ns hello-world.core
  (:require [clojure.browser.repl :as repl]
            [domina :as dom]
            [domina.events :as ev]))

(enable-console-print!)

(defn arithmetic [a b]
  (/ (+ a b) 2.0))

(defn geometric [a b]
  (js/Math.sqrt (* a b)))

(defn harmonic [a b]
  (/ 2 (+ (/ 1 a) (/ 1 b))))

(defn float-value [id]
  (.parseFloat js/window (dom/value (dom/by-id id))))

(defn doCal [fun]
  (fun (float-value "A") (float-value "B")))

(defn calculate [e]
  (dom/set-text! (dom/by-id "arithmetic")
                 (doCal arithmetic))
  (dom/set-text! (dom/by-id "geometric")
                 (doCal geometric))
  (dom/set-text! (dom/by-id "harmonic")
                 (doCal harmonic)))
(ev/listen! (dom/by-id "calc") "click" calculate)

