import './App.css';
import { useReducer } from "react";
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

 </>
);

}

function ShowSlider({run})
{
  
if(run){
    return(
    <>
    <SliderCompo />
    </>
    );
    }
    else{
      return(
        <>
        <label>Temperature</label>
        <div
        style={{
          width: "300px",
          height: "100px",
          border: "1px solid #000",
          background: "##f0f0f5"
        }}
        >
        </div>
        </>
      );
    }
  
}


export default SliderCompoStartStop;
