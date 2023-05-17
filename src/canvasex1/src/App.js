import logo from './logo.svg';
import './App.css';
import Canvas from "./Canvas";

const draw = (context) => {
  context.fillStyle = "rgb(200, 0, 0)";
  context.fillRect(10, 10, 50, 50);
  context.stroke();
};

const drawCircle = (context) => {
  context.beginPath();
  context.arc(100, 75, 50, 0, 2 * Math.PI);
  context.stroke();
};

const drawEllipse = (context) => {
  // Draw the ellipse
  context.beginPath();
  context.ellipse(100, 100, 50, 75, Math.PI / 4, 0, 2 * Math.PI);
  context.stroke();

  // Draw the ellipse's line of reflection
  context.beginPath();
  context.setLineDash([5, 5]);
  context.moveTo(0, 200);
  context.lineTo(200, 0);
  context.stroke();
};

function App() {
  return (
    <>
      <Canvas draw={draw} height={100} width={100} />
      <Canvas draw={drawCircle} height={500} width={500} />
      <Canvas draw={drawEllipse} height={500} width={500} />
    </>
  );
}

export default App;
