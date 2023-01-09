import React from "react";
import '../css/TodoListTemplate.css';

const TodoListTemplate = ({form, children}) => {
    return (
        <main className={"todo-background"}>
            <div className={"group1"}>
                <span className = {"todo-list-template"}></span>
                <span className = {"todo-list-title"}>Todo List</span>
                <span className = {"todo-content"}>{children}</span>
                <span className = {"todo-line"}></span>
                <span className = {"check-box"}></span>
            </div>
            <div className = {"group2"}>
                <span className = {"rabbit"}></span>
                <span className = {"pencil"}></span>
            </div>
        </main>
    );
};

export default TodoListTemplate;