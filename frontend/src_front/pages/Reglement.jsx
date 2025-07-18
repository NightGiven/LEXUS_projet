import React, { useEffect, useState } from "react";
import { getReglements, createReglement, deleteReglement } from "com/example/System_gestion_LEXUS/Services/ReglementService";

const ReglementsPage = () => {
  const [list, setList] = useState([]);
  const [newR, setNewR] = useState({
    montantTotal: "",
    montantPaye: "",
    montantRestant: "",
    typePaiement: "",
    clientCin: ""
  });

  useEffect(() => { load(); }, []);

  const load = async () => {
    const res = await getReglements();
    setList(res.data);
  };

  const handleAdd = async () => {
    await createReglement(newR);
    setNewR({ montantTotal: "", montantPaye: "", montantRestant: "", typePaiement: "", clientCin: "" });
    load();
  };

  const handleDelete = async (id) => {
    await deleteReglement(id);
    load();
  };

  return (
    <div>
      <h2>Gestion des Règlements</h2>
      <ul>
        {list.map(r => (
          <li key={r.id}>
            {r.montantTotal} MAD - {r.typePaiement} - Client: {r.clientCin}
            <button onClick={() => handleDelete(r.id)}>Supprimer</button>
          </li>
        ))}
      </ul>

      <h3>Ajouter un règlement</h3>
      <input type="number" placeholder="Montant Total" value={newR.montantTotal}
        onChange={e => setNewR({ ...newR, montantTotal: e.target.value })} />
      <input placeholder="Type Paiement" value={newR.typePaiement}
        onChange={e => setNewR({ ...newR, typePaiement: e.target.value })} />
      <input placeholder="Client CIN" value={newR.clientCin}
        onChange={e => setNewR({ ...newR, clientCin: e.target.value })} />
      <button onClick={handleAdd}>Ajouter</button>
    </div>
  );
};

export default ReglementsPage;
