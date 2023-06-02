import reservationData from "./Data/reservationData.js";

const ReserveServicesMock = {
  getAllReserves: () => {
    console.log(reservationData);
    return reservationData;
  },
  createReserve: (reserve) => {
    return {
      id: Date.now(),
      name: "Luis",
      active: true,
      thing: "thing1",
      due: "2022-01-16",
      dateCompleted: "2023-05-28"
    };
  },

  updateReserve: (todo, id) => {
    return todo.map((item) => {
      if (item.id === id) {
        return {
          ...item,
          completed: !item.active
        };
      }
      return item;
    });
  },

  deleteReserve: (todoId) => {
    return reservationData.filter((item) => item.id !== todoId);
  }
};

export default ReserveServicesMock;
