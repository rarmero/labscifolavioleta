import React, { useContext } from "react";
import ReserveAdd from "./ReserveAdd";
import ReserveList from "./ReserveList";
import {
  ReserveContext,
  ReserveProvider
} from "../../Service/ReserveContext.js";

const ReserveApp = () => {
  const { reserves, createReserve, updateReserve, deleteReserve } = useContext(
    ReserveContext
  );

  const handleCreateReserve = (reserve) => {
    createReserve(reserve);
  };

  const handleUpdateReserve = (reserve) => {
    updateReserve(reserve);
  };

  const handleDeleteReserve = (reserveId) => {
    deleteReserve(reserveId);
  };

  return (
    <div>
      <h1>Reserve App</h1>
      <ReserveAdd onCreate={handleCreateReserve} />
      <ReserveList
        reserves={reserves}
        onDelete={handleDeleteReserve}
        onUpdate={handleUpdateReserve}
      />
    </div>
  );
};

const App = () => {
  return (
    <ReserveProvider>
      <ReserveApp />
    </ReserveProvider>
  );
};

export default App;
