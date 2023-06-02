import axios from "axios";

///`${API_URL}/todo`
// https://github.com/mockapi-io/docs/wiki/Quick-start-guide
// API_URL mockapi.io
const API_BASE_URL = "https://6470cdec3de51400f724f4d3.mockapi.io/api";

const PersonService = {
  getAllPersons: async () => {
    try {
      const response = await axios.get(`${API_BASE_URL}/person`);
      // console.log("retrieving todos:", response.data);
      return response.data;
    } catch (error) {
      console.error("Error retrieving persons:", error);
      throw error;
    }
  },

  createPerson: async (todo) => {
    console.log(todo);
    try {
      const response = await axios.post(`${API_BASE_URL}/person`, todo);
      return response.data;
    } catch (error) {
      console.error("Error creating person:", error);
      throw error;
    }
  },

  updatePerson: async (todo) => {
    try {
      const response = await axios.put(
        `${API_BASE_URL}/person/${todo.id}`,
        todo
      );
      return response.data;
    } catch (error) {
      console.error("Error updating person:", error);
      throw error;
    }
  },

  deletePerson: async (todoId) => {
    try {
      const response = await axios.delete(`${API_BASE_URL}/person/${todoId}`);
      return response.data;
    } catch (error) {
      console.error("Error deleting person:", error);
      throw error;
    }
  }
};

export default PersonService;
