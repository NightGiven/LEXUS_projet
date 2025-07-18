import axios from "axios";

const API_URL = "http://localhost:8080/api/reglements";

export const getReglements = () => axios.get(API_URL);

export const createReglement = (reglement) => axios.post(API_URL, reglement);

export const deleteReglement = (id) => axios.delete(`${API_URL}/${id}`);

export const getReglementById = (id) => axios.get(`${API_URL}/${id}`);

export const updateReglement = (id, reglement) => axios.put(`${API_URL}/${id}`, reglement);
