import React, { useEffect, useState } from "react";
import { getClients, createClient, deleteClient } from "com/example/System_gestion_LEXUS/Services";

const ClientsPage = () => {
  const [clients, setClients] = useState([]);
  const [newClient, setNewClient] = useState({
    cin: "",
    nom: "",
    prenom: "",
    telephone: "",
    email: ""
  });

  useEffect(() => {
    loadClients();
  }, []);

  const loadClients = async () => {
    const res = await getClients();
    setClients(res.data);
  };

  const handleAdd = async () => {
    await createClient(newClient);
    setNewClient({ cin: "", nom: "", prenom: "", telephone: "", email: "" });
    loadClients();
  };

  const handleDelete = async (cin) => {
    await deleteClient(cin);
    loadClients();
  };

  return (
    <div>
      <h2>Gestion des Clients</h2>
      <ul>
        {clients.map(c => (
          <li key={c.cin}>
            {c.nom} {c.prenom} - {c.telephone} - {c.email}
            <button onClick={() => handleDelete(c.cin)}>Supprimer</button>
          </li>
        ))}
      </ul>

      <h3>Ajouter un client</h3>
      <input placeholder="CIN" value={newClient.cin} onChange={e => setNewClient({ ...newClient, cin: e.target.value })} />
      <input placeholder="Nom" value={newClient.nom} onChange={e => setNewClient({ ...newClient, nom: e.target.value })} />
      <input placeholder="Prénom" value={newClient.prenom} onChange={e => setNewClient({ ...newClient, prenom: e.target.value })} />
      <input placeholder="Téléphone" value={newClient.telephone} onChange={e => setNewClient({ ...newClient, telephone: e.target.value })} />
      <input placeholder="Email" value={newClient.email} onChange={e => setNewClient({ ...newClient, email: e.target.value })} />
      <button onClick={handleAdd}>Ajouter</button>
    </div>
  );
};

export default ClientsPage;
