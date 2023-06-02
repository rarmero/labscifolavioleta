import React, { createContext, useState, useEffect } from "react";
import ReserveService from "./ReserveServiceRest";
//import ReserveService from "./ReserveServiceMock";

const ReserveContext = createContext();

const ReserveProvider = ({ children }) => {
  const [reserves, setReserves] = useState([]);

  //
  useEffect(() => {
    fetchReserves();
  }, []);

  //
  const fetchReserves = async () => {
    try {
      const reserves = await ReserveService.getAllReserves();
      setReserves(reserves);
      // console.log("reserves:", reserves);
    } catch (error) {
      console.error("Error fetching todos:", error);
    }
  };

  //
  const createReserve = async (reserve) => {
    console.log(reserve);
    try {
      const createdReserve = await ReserveService.createReserve(reserve);
      setReserves((prevReserves) => [...prevReserves, createdReserve]);
    } catch (error) {
      console.error("Error creating todo:", error);
    }
  };

  //
  const updateReserve = async (reserveToUpdate) => {

    try {

      const updatedReserve = {
        ...reserveToUpdate,
        accepted: !reserveToUpdate.accepted
      };

      await ReserveService.updateReserve(updatedReserve);
      
      setReserves((prevReserves) => {
        const updatedReserves = [...prevReserves];
        const reserveIndex = updatedReserves.findIndex(
          (reserve) => reserve.id === updatedReserve.id
        );
        updatedReserves[reserveIndex] = updatedReserve;
        return updatedReserves;
      });
    } catch (error) {
      console.error("Error updating todo:", error);
    }
  };

  //
  const deleteReserve = async (reserveId) => {
    try {
      await ReserveService.deleteReserve(reserveId);
      setReserves((prevReserves) =>
        prevReserves.filter((reserve) => reserve.id !== reserveId)
      );
    } catch (error) {
      console.error("Error deleting todo:", error);
    }
  };

  //
  return (
    <ReserveContext.Provider
      value={{ reserves, createReserve, updateReserve, deleteReserve }}
    >
      {children}
    </ReserveContext.Provider>
  );
};

export { ReserveContext, ReserveProvider };
