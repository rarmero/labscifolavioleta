import React from "react";
import Highcharts from "highcharts/highstock";
import PieChart from "highcharts-react-official";

const App = ({ items }) => {
  const authorMap = {};
  console.log(items);

  items.forEach((item) => {
    const { price } = item;
    if (authorMap[price]) {
      authorMap[price]++;
    } else {
      authorMap[price] = 1;
    }
  });

  const result = Object.entries(authorMap).map(([price, count]) => ({
    name: price,
    y: count
  }));

  return (
    <div style={{ margin: "40px" }}>
      <PieChartState result={result} />
    </div>
  );
};

export default App;

function PieChartState({ result }) {
  const options = {
    title: {
      text: "commits by status"
    },
    chart: {
      type: "pie"
    },
    series: [
      {
        data: result
      }
    ]
  };
  return (
    <>
      <PieChart highcharts={Highcharts} options={options} />
    </>
  );
}