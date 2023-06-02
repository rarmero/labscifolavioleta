import React from "react";
import PersonItem from "./PersonItem";

// CRUD: read and create list
const PersonList = ({ persons, onDelete, onUpdate }) => {
  if (persons === null) {
    return <p>Loading...</p>;
  }

  return (
    <>
      <h2>Persons List</h2>
      <hr />
      {persons.map((person) => (
        <PersonItem
          key={person.id}
          person={person}
          onDelete={onDelete}
          onUpdate={onUpdate}
        />
      ))}
    </>
  );
};

export default PersonList;
