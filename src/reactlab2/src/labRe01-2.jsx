import './App.css';
import Box from '@mui/material/Box';
import Slider from '@mui/material/Slider';
import { useReducer,useRef,useState,useEffect } from "react";

const marks = [
  {
    value: 0,
    label: '0°C',
  },
  {
    value: 20,
    label: '20°C',
  },
  {
    value: 37,
    label: '37°C',
  },
  {
    value: 100,
    label: '100°C',
  },
];

function reducer(state, action) {

  switch (action.type) {
    case "start":
      return { ...state, isRunning: true };
    case "stop":
      return { ...state, isRunning: false };
    case "change_temperature": {
      return {
        valueTemperature: action.ValueTemperature  
      };
    }
    default: {
      throw Error("Unknown action: " + state.valueTemperature);
    }
  }
}

const initialState = { 
  isRunning: false,
  valueTemperature: "20" };

function valuetext(value) {
  return `${value}°C`;
}

function App() {

  const [state, dispatch] = useReducer(reducer, initialState);
  const [number, setNumber] = useState(0);
  const idRef = useRef(20);

  useEffect(() => {
    console.log("useEffect");
    if (!state.isRunning) {
      return;
    }
    idRef.current = valuetext;
    console.log(idRef.current);

    return () => {
      console.log("useEffect");
    //  clearInterval(idRef.current);
    //  idRef.current = 0;
      console.log(idRef.current);
    };
  }, [state.isRunning]);

  function handleChangeTemperature(e)
  {
    dispatch({
      type: "change_temperature",
      ValueTemperature: e.target.value
    });
  }


  return (
    <>

<button onClick={() => dispatch({ type: "start" })}>Start</button>

<button onClick={() => dispatch({ type: "stop" })}>
  Stop</button>

    <Box sx={{ width: 300 }}>
      <Slider
        aria-label="Custom marks"
        defaultValue={20}
        getAriaValueText={valuetext}
        step={10}
        valueLabelDisplay="auto"
        marks={marks}
        onChange={handleChangeTemperature}        
      />
    </Box>

    <label>Temperature</label>{" "}
    <input value={state.valueTemperature}/>

    <p>
        <strong>Temperature:</strong> {state.valueTemperature}
      </p>

    </>
  );
}

export default App;
