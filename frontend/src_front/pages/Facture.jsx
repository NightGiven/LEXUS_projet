import React, { useEffect, useState } from "react";
import { getFactures, createFacture, deleteFacture } from "com/example/System_gestion_LEXUS/Services/";

const FacturesPage = () => {
  const [list, setList] = useState([]);
  const [newF, setNewF] = useState({ clientCin: "" });

  useEffect(() => { load(); }, []);

  const load = async () => {
    const res = await getFactures();
    setList(res.data);
  };

  const handleAdd = async () => {
    await createFacture(newF);
    setNewF({ clientCin: "" });
    load();
  };

  const handleDelete = async (id) => {
    await deleteFacture(id);
    load();
  };

  return (
    <div>
      <h2>Gestion des Factures</h2>
      <ul>
        {list.map(f => (
          <li key={f.id}>
            Facture #{f.id} - Client: {f.clientCin}
            <button onClick={() => handleDelete(f.id)}>Supprimer</button>
          </li>
        ))}
      </ul>

      <h3>Ajouter une facture</h3>
      <input placeholder="Client CIN" value={newF.clientCin}
        onChange={e => setNewF({ ...newF, clientCin: e.target.value })} />
      <button onClick={handleAdd}>Ajouter</button>
    </div>
  );
};

export default FacturesPage;
