import React, { useContext } from "react";
import PersonAdd from "./PersonAdd";
import PersonList from "./PersonList";
import { PersonContext, PersonProvider } from "../../Service/PersonContext.js";

const PersonApp = () => {
  const { persons, createPerson, updatePerson, deletePerson } = useContext(
    PersonContext
  );

  const handleCreatePerson = (person) => {
    createPerson(person);
  };

  const handleUpdatePerson = (person) => {
    updatePerson(person);
  };

  const handleDeletePerson = (personId) => {
    deletePerson(personId);
  };

  return (
    <div>
      <h1>Person App</h1>
      <PersonAdd onCreate={handleCreatePerson} />
      <PersonList
        persons={persons}
        onDelete={handleDeletePerson}
        onUpdate={handleUpdatePerson}
      />
    </div>
  );
};

const App = () => {
  return (
    <PersonProvider>
      <PersonApp />
    </PersonProvider>
  );
};

export default App;
