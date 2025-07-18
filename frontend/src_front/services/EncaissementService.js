import axios from "axios";

const API_URL = "http://localhost:8080/api/encaissements";

export const getEncaissements = () => axios.get(API_URL);

export const createEncaissement = (encaissement) => axios.post(API_URL, encaissement);

export const deleteEncaissement = (id) => axios.delete(`${API_URL}/${id}`);

export const getEncaissementById = (id) => axios.get(`${API_URL}/${id}`);

export const updateEncaissement = (id, encaissement) => axios.put(`${API_URL}/${id}`, encaissement);
