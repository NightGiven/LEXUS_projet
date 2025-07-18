import axios from "axios";

const API_URL = "http://localhost:8080/api/clients";

// Récupérer tous les clients (GET)
export const getClients = () => axios.get(API_URL);

// Ajouter un nouveau client (POST)
export const createClient = (client) => axios.post(API_URL, client);

// Supprimer un client par CIN (DELETE)
export const deleteClient = (cin) => axios.delete(`${API_URL}/${cin}`);

// Récupérer un client par CIN (GET by ID)
export const getClientByCin = (cin) => axios.get(`${API_URL}/${cin}`);

//  Mettre à jour un client existant (PUT)
export const updateClient = (cin, client) => axios.put(`${API_URL}/${cin}`, client);
