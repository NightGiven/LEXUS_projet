import axios from "axios";

const API_URL = "http://localhost:8080/api/factures";

export const getFactures = () => axios.get(API_URL);
export const createFacture = (facture) => axios.post(API_URL, facture);
export const deleteFacture = (id) => axios.delete(`${API_URL}/${id}`);
export const getFactureById = (id) => axios.get(`${API_URL}/${id}`);
export const updateFacture = (id, facture) => axios.put(`${API_URL}/${id}`, facture);
