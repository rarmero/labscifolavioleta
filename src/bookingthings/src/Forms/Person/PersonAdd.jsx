import React from "react";

const PersonAdd = ({ onCreate }) => {
  const [name, setName] = React.useState("");
  const [surname, setSurname] = React.useState("");
  const [birth, setBirth] = React.useState("");
  const [active, setActive] = React.useState("");
  const [createdAt, setCreatedAt] = React.useState("");

  const handleSubmit = () => {
    onCreate({
      name: name,
      surname: surname,
      active: active,
      createdAt: createdAt,
      birth: birth
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:{" "}
        <input
          name="name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </label>
      <br />
      <label>
        Surmane:{" "}
        <input
          name="surname"
          value={surname}
          onChange={(e) => setSurname(e.target.value)}
        />
      </label>
      <br />
      <label>
        Birth:{" "}
        <input
          name="birth"
          type="date"
          value={birth}
          onChange={(e) => setBirth(e.target.value)}
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

export default PersonAdd;
