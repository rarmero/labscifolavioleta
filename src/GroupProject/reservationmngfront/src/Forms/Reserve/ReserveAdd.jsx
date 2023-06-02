import React from "react";
import DateStartEnd from "./DateStartEnd.js";

//Enclosed in quotes and in the format: yyyy-mm-dd

const ReserveAdd = ({ onCreate }) => {
  const [name, setName] = React.useState("");
  const [thing, setThing] = React.useState("");
  const [due, setDue] = React.useState("");
  const [accepted, setAccepted] = React.useState("");
  const [createdAt, setCreatedAt] = React.useState("");
  const [dateCompleted, setDateCompleted] = React.useState("");
  const [dateStart, setDateStart] = React.useState("");
  const [dateEnd, setDateEnd] = React.useState("");

  const handleSubmit = () => {
    onCreate({
      name: name,
      thing: thing,
      due: due,
      createdAt: createdAt,
      dateCompleted: dateCompleted,
      dateStart: dateStart,
      dateEnd: dateEnd,
      accepted : accepted
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Thing:
        <input
          name="thing"
          value={thing}
          onChange={(e) => setThing(e.target.value)}
          placeholder="Enter thing name"
        />
      </label>
      <br />
      <label>
        Name:
        <input
          name="name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Enter client name"
        />
      </label>
      <br />
      <label>
        Date Start:
        <input
          type="datetime-local"
          name="dateStart"
          value={dateStart}
          onChange={(e) => setDateStart(e.target.value)}
        />
      </label>
      <label>
        Date End:
        <input
          type="datetime-local"
          name="dateEnd"
          value={dateEnd}
          onChange={(e) => setDateEnd(e.target.value)}
        />{" "}
      </label>
      <br />
      <label>
        Date Completed:
        <input
          type="datetime-local"
          name="dateCompleted"
          value={dateCompleted}
          onChange={(e) => setDateCompleted(e.target.value)}
        />
      </label>
      <br />
      <p>
        <label> Due</label>
        <br />
        <input
          type="date"
          value={due}
          onChange={(e) => setDue(e.target.value)}
        />
      </p>
      <label>
        Accepted:{" "}
        <input
          type="checkbox"
          name="accepted"
          defaultChecked={true}
          value={accepted}
          onChange={(e) => setAccepted(e.target.value)}
        />
      </label>
      <br />
      <button type="submit">Add</button>
    </form>
  );
};

export default ReserveAdd;
