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
        valueTemperature: action.NextValueTemperature  ,
         valueColor: action.NextColor
      };
    }
    default: {
      throw Error("Unknown action: " + state.valueTemperature);
    }
  }
}

const initialState = {valueTemperature: "20", valueColor: "blue" };

function valuetext(value) {
  return `${value}°C`;
}

function SliderCompo() {

  const [state, dispatch] = useReducer(reducer, initialState);

  function handleChangeTemperature(e)
  {
    let c;
    if (e.target.value >= 0 && e.target.value < 21) {
      c = "Fuchsia";
    } else if (e.target.value >= 20 && e.target.value < 60) {
      c = "blue";
    } else {
      c = "red";
    }

    dispatch({
      type: "change_temperature",
      NextValueTemperature: e.target.value,
      NextColor: c
    });
  }

  return (
    <>
    <div>
        <label>Temperature</label>{" "}
        <div
          style={{
            width: "300px",
            height: "100px",
            border: "1px solid #000",
            background: state.valueColor
          }}
        >
          <center>
            {" "}
            <p>{state.valueTemperature}</p>
          </center>
        </div>
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
      </div>
    </>
  );
}

export default SliderCompo;
