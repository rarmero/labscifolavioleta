import logo from './logo.svg';
import './App.css';
import Canvas from "./Canvas";

const draw = (context) => {
  context.fillStyle = "rgb(200, 0, 0)";
  context.fillRect(10, 10, 50, 50);


};

function App() {
  return (
    <>
       <Canvas draw={draw} height={100} width={100} />
    </>
  );
}
export default App;
