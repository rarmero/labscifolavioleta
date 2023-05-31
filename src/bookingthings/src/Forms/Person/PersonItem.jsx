import React from "react";

// CRUD: read and render item from list
const PersonItem = ({ person, onDelete, onUpdate }) => {
  const handleDelete = () => {
    onDelete(person.id);
  };

  const handleUpdate = () => {
    onUpdate(person);
  };

  return (
    <>
      <h4>Name: {person.name}</h4>
      <h4>Surname: {person.surname}</h4>

      <div style={{ display: "flex", justifyContent: "space-between" }}>
        <button onClick={handleDelete}>Delete</button>
        <div>
          Active:{" "}
          <input
            type="checkbox"
            value={person.active}
            onChange={handleUpdate}
          ></input>
        </div>
      </div>

      <br />
    </>
  );
};

export default PersonItem;
