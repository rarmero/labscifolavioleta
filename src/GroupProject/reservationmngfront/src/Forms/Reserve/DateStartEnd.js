const DateStartEnd = () => {
  return (
    <>
      <label>
        Date Start:
        <input type="datetime-local" name="dateStart" />
      </label>
      <label>
        Date End:
        <input type="datetime-local" name="dateEnd" />{" "}
      </label>
    </>
  );
};

export default DateStartEnd;
