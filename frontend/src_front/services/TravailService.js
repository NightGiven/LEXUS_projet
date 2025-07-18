import axios from "axios";

const API_URL = "http://localhost:8080/api/travaux";

export const getServices = () => axios.get(API_URL);
export const createService = (service) => axios.post(API_URL, service);
export const deleteService = (id) => axios.delete(`${API_URL}/${id}`);
export const getServiceById = (id) => axios.get(`${API_URL}/${id}`);
export const updateService = (id, service) => axios.put(`${API_URL}/${id}`, service);
