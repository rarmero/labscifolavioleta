import './App.css';
import Box from '@mui/material/Box';
import Slider from '@mui/material/Slider';
import { useReducer } from "react";

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
  valueTemperature: "20" };

function valuetext(value) {
  return `${value}°C`;
}

function App() {

  const [state, dispatch] = useReducer(reducer, initialState);

  function handleChangeTemperature(e)
  {
    dispatch({
      type: "change_temperature",
      ValueTemperature: e.target.value
    });
  }


  return (
    <>
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
