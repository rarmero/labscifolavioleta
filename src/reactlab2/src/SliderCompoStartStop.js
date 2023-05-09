import './App.css';
import { useReducer,useRef,useState,useEffect } from "react";
import SliderCompo from './SliderCompo.js'


const initialState = { 
  isRunning: false
};

function reducer(state, action) {

  switch (action.type) {
    case "start":
      return { ...state, isRunning: true };
    case "stop":
      return { ...state, isRunning: false };
     default: {
      throw Error("Unknown action: ");
    }
  }
}

function SliderCompoStartStop() {
  
const [state, dispatch] = useReducer(reducer, initialState);
  
return(
  <>
  <ShowSlider run={state.isRunning} />
  <button onClick={() => dispatch({ type: "start" })}>Start</button>
  <button onClick={() => dispatch({ type: "stop" })}>Stop</button>

  <input value={state.isRunning} />
 </>
);

}

function ShowSlider({run})
{
  if (run){
    return <>
    <h1>That's right!</h1><SliderCompo />
    </>

  }

}

export default SliderCompoStartStop;
