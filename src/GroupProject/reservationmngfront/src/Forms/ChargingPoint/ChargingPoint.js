import React from "react";

const ChargingPoint = ({ onCreate }) => {
  const [namePerson, setNamePerson] = React.useState("");
  const [active, setActive] = React.useState("");

  const handleSubmit = () => {
    onCreate({
      namePerson: namePerson,
      active: active
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:{" "}
        <input
          name="namePerson"
          value={namePerson}
          onChange={(e) => setNamePerson(e.target.value)}
        />
      </label>
      <br />
      <label>
        Active:{" "}
        <input
          type="checkbox"
          name="active"
          defaultChecked={true}
          value={active}
          onChange={(e) => setActive(e.target.value)}
        />
      </label>
      <br />
      <button type="submit">Add</button>
    </form>
  );
};

export default ChargingPoint;
