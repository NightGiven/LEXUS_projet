import axios from "axios";

const API_URL = "http://localhost:8080/api/types-paiement";

export const getTypesPaiement = () => axios.get(API_URL);
export const createTypePaiement = (type) => axios.post(API_URL, type);
export const deleteTypePaiement = (id) => axios.delete(`${API_URL}/${id}`);
export const getTypePaiementById = (id) => axios.get(`${API_URL}/${id}`);
export const updateTypePaiement = (id, type) => axios.put(`${API_URL}/${id}`, type);
