(ns todomvc
  (:require-macros
    [reactjs.macro :refer [pure]])
  (:require
    React
    reactjs.core
    [reactjs.dom :as dom]))

(def app-state
  (atom {:completed-count 0
         :now-showing 0
         :todos []}))

(defn todo-item [todo]
  )

(defn toggle-all [e]
  )

(defn handle-todo-keydown [e]
  )

(defn todo-app []
  (let [main (dom/section #js {:id "main"}
               (dom/input #js {:id "toggle-all"
                               :type "checkbox"
                               :on-change toggle-all})
               (dom/ul #js {:id "todo-list"}
                 (into-array (map todo-item @todos))))
        footer ]
    ((fn loop []
       (React/renderComponent
         (pure @todos
           (dom/div nil
             (dom/header #js {:id "header"}
               (array
                 (dom/h1 nil "todos")
                 (dom/input #js {:ref "newField"
                                 :id  "new-todo"
                                 :placeholder "What needs to be done?"
                                 :on-key-down #(do (handle-todo-keydown %) (loop))})
                 main footer)))))))))
