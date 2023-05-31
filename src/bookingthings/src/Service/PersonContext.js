import React, { createContext, useState, useEffect } from "react";
import PersonService from "./PersonService";

const PersonContext = createContext();

const PersonProvider = ({ children }) => {
  const [persons, setPersons] = useState([]);

  //
  useEffect(() => {
    fetchPersons();
  }, []);

  //
  const fetchPersons = async () => {
    try {
      const persons = await PersonService.getAllPersons();
      setPersons(persons);
    } catch (error) {
      console.error("Error fetching persons:", error);
    }
  };

  //
  const createPerson = async (person) => {
    console.log(person);
    try {
      const createdPerson = await PersonService.createPerson(person);
      setPersons((prevPersons) => [...prevPersons, createdPerson]);
    } catch (error) {
      console.error("Error creating person:", error);
    }
  };

  //
  const updatePerson = async (updatedPerson) => {
    try {
      await PersonService.updatePeson(updatedPerson);
      setPersons((prevPersons) => {
        const updatedPersons = [...prevPersons];
        const personIndex = updatedPersons.findIndex(
          (person) => person.id === updatedPerson.id
        );
        updatedPersons[personIndex] = updatedPersons;
        return updatedPersons;
      });
    } catch (error) {
      console.error("Error updating person:", error);
    }
  };

  //
  const deletePerson = async (personId) => {
    try {
      await PersonService.deletePerson(personId);
      setPersons((prevPersons) =>
        prevPersons.filter((person) => person.id !== personId)
      );
    } catch (error) {
      console.error("Error deleting person:", error);
    }
  };

  //
  return (
    <PersonContext.Provider
      value={{ persons, createPerson, updatePerson, deletePerson }}
    >
      {children}
    </PersonContext.Provider>
  );
};

export { PersonContext, PersonProvider };
