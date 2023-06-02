import React from "react";

// CRUD: read and render item from list
const ReserveItem = ({ reserve, onDelete, onUpdate }) => {
  const handleDelete = () => {
    onDelete(reserve.id);
  };

  const handleUpdate = () => {
    onUpdate(reserve);
  };

  return (
    <>
     <h3>ID Client: {reserve.idUser}</h3>
      <h3>Client: {reserve.name}</h3>
      <h3>ID Thing: {reserve.idPointCharge}</h3>      
      <p>
        Date start:{reserve.dateStart} , Date end: {reserve.dateEnd}
      </p>
      <div style={{ display: "flex", justifyContent: "space-between" }}>
        <button onClick={handleDelete}>Delete</button>
        <div>
          Active:{" "}
          <input
            type="checkbox"
            value={reserve.accepted}
            onChange={handleUpdate}
          ></input>
        </div>
      </div>

      <br />
      <br />
      <hr />
    </>
  );
};

export default ReserveItem;
