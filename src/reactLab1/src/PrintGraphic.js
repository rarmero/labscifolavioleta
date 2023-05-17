import React from "react";
import Highcharts from "highcharts/highstock";
import PieChart from "highcharts-react-official";

const App = ({ items }) => {
  const authorMap = {};
  console.log(items);

  items.forEach((item) => {
    const { status } = item;
    if (authorMap[status]) {
      authorMap[status]++;
    } else {
      authorMap[status] = 1;
    }
  });

  const result = Object.entries(authorMap).map(([status, count]) => ({
    name: status,
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