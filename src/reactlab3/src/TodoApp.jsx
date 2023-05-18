import React, { useReducer } from "react";
import {getDate, getDateDue } from "./helper";


const initialTodos = [
  {
    id: 1,
    dateCreated : "2023-01-15",
    text: "lean how to comunicate",
    completed: true,
    dateCompleted:  "2023-01-20",
    progress: 100,
    author: "Faby",
    due: "2023-01-20"
  },
  {
    id: 2,
    dateCreated : "2023-01-21",
    text: "road out of hell",
    completed: false,
    dateCompleted: "" ,
    progress: 50,
    author: "Alex",
    due: "2023-01-25"
  }
];

  

function appReducer(state, action) {
  switch (action.type) {
    case "add": {
  
      return [
        ...state,
        {
          id: Date.now(),
          dateCreated: getDate(),
          text: "",
          completed:false,
          dateCompleted: "",
          progress:0,
          author: "",
          due: getDateDue(),
          delay: ""
        }
      ];
    }
    case "delete": {
      return state.filter((item) => item.id !== action.payload);
    }
    case "completed": {
      return state.map((item) => {
        if (item.id === action.payload) {
          return {
            ...item,
            completed: !item.completed,
            dateCompleted: getDate()
          };
        }
        return item;
      });
    }
    case "clear": {
      return [...initialTodos];
    }   
    case "update": {
      const { id, field, value } = action.payload;

      return state.map((item) => {
        if (item.id === id) {
          return {
            ...item,
            [field]: value
          };
        }
        return item;
      });
    }
    default: {
      return state;
    }
  }
}

export default function TodoApp() {
  const [state, dispatch] = useReducer(appReducer, initialTodos);

  const handleUpdate = (id, field, value) => {
    dispatch({
      type: "update",
      payload: {
        id,
        field,
        value
      }
    });
  };

  return (
    <>

      <h3>Taks list</h3>
     
      <br /> <br />
    <div>
          {state.map((item) => (
         
             <React.Fragment key={item.id}>
      
            <input type="checkbox" checked={item.completed} onChange={() => dispatch({ type: "completed", payload: item.id })}/> 
            <input type="date" value={item.dateCompleted} onChange={(e) => handleUpdate(item.id, "dateCompleted", e.target.value)} />{" "}
            <input type="text" value={item.text} onChange={(e) => handleUpdate(item.id, "text", e.target.value)}/>{" "} 
            <input type="text" value={item.author} onChange={(e) => handleUpdate(item.id, "author", e.target.value)}/>{" "} 
            <input type="date" value={item.dateCreated} onChange={(e) => handleUpdate(item.id, "dateCreated", e.target.value)} />{" "} 
            <input type="range" min="0" max="100" value={item.progress } onChange={() => dispatch({ type: "progress", payload: item.id})} />{" "} 
            <input type="date" value={item.due }  onChange={(e) => handleUpdate(item.id, "due", e.target.value)} />{" "}
            <button onClick={() => dispatch({ type: "delete", payload: item.id })}> Delete </button>
            <br />    
            </React.Fragment>
        
       ))}
         
      </div>
      <div align="center">
      <button onClick={() => dispatch({ type: "add" })}>
        Create Todo
      </button>{" "}
      <button onClick={() => dispatch({ type: "clear" })}>Clear Todo</button>
      </div>
    
    </>
  );
}