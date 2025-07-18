import React, { useEffect, useState } from "react";
import { getTypesPaiement, createTypePaiement, deleteTypePaiement } from "com/example/System_gestion_LEXUS/Services";

const TypesPaiementPage = () => {
  const [list, setList] = useState([]);
  const [newT, setNewT] = useState({ nom: "" });

  useEffect(() => { load(); }, []);

  const load = async () => {
    const res = await getTypesPaiement();
    setList(res.data);
  };

  const handleAdd = async () => {
    await createTypePaiement(newT);
    setNewT({ nom: "" });
    load();
  };

  const handleDelete = async (id) => {
    await deleteTypePaiement(id);
    load();
  };

  return (
    <div>
      <h2>Gestion des Types de Paiement</h2>
      <ul>
        {list.map(t => (
          <li key={t.id}>
            {t.nom}
            <button onClick={() => handleDelete(t.id)}>Supprimer</button>
          </li>
        ))}
      </ul>

      <h3>Ajouter un type de paiement</h3>
      <input placeholder="Nom" value={newT.nom}
        onChange={e => setNewT({ ...newT, nom: e.target.value })} />
      <button onClick={handleAdd}>Ajouter</button>
    </div>
  );
};

export default TypesPaiementPage;
