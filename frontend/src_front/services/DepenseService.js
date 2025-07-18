import axios from "axios";

const API_URL = "http://localhost:8080/api/depenses";

export const getDepenses = () => axios.get(API_URL);
export const createDepense = (depense) => axios.post(API_URL, depense);
export const deleteDepense = (id) => axios.delete(`${API_URL}/${id}`);
export const getDepenseById = (id) => axios.get(`${API_URL}/${id}`);
export const updateDepense = (id, depense) => axios.put(`${API_URL}/${id}`, depense);
