import axios from "axios";

const API_BASE_URL = "http://localhost:8082/api";

const ENTITY = "/reservations";
//const ENTITY = "/reserve";

const ReserveServiceRest = {
  getAllReserves: async () => {
    try {
      const response = await axios.get(`${API_BASE_URL}${ENTITY}`);
      // console.log("retrieving todos:", response.data);
      return response.data;
    } catch (error) {
      console.error("Error retrieving todos:", error);
      throw error;
    }
  },

  createReserve: async (todo) => {
  
    try {
      const response = await axios.post(`${API_BASE_URL}/reservationAdd`, todo);
      return response.data;
    } catch (error) {
      console.error("Error creating todo:", error);
      throw error;
    }
  },

  updateReserve: async (todo) => {
    console.log(todo);
    try {
      //const response = await axios.put(`${API_BASE_URL}/reservationUpdate/${todo.id}`,todo);                
      const response = await axios.put(`${API_BASE_URL}/reservationUpdate`,todo);                
      return response.data;
    } catch (error) {
      console.error("Error updating todo:", error);
      throw error;
    }
  },

  deleteReserve: async (todoId) => {
    try {
      const response = await axios.delete(`${API_BASE_URL}/reservationDelete?id=${todoId}`);
      return response.data;
    } catch (error) {
      console.error("Error deleting todo:", error);
      throw error;
    }
  }
};

export default ReserveServiceRest;
