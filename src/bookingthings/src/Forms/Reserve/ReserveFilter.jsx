
const ReserveFilter = () => {

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

export default ReserveFilter;
