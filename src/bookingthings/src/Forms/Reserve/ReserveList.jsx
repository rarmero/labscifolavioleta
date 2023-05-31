import React from "react";
import ReserveItem from "./ReserveItem";

// CRUD: read and create list
const ReserveList = ({ reserves, onDelete, onUpdate }) => {
  if (reserves === null) {
    return <p>Loading...</p>;
  }

  return (
    <>
      <h2>Reserves List</h2>
      <hr />
      {reserves.map((reserve) => (
        <ReserveItem
          key={reserve.id}
          reserve={reserve}
          onDelete={onDelete}
          onUpdate={onUpdate}
        />
      ))}
    </>
  );
};

export default ReserveList;
