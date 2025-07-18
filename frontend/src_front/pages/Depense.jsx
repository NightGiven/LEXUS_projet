import React, { useEffect, useState } from "react";
import { getDepenses, createDepense, deleteDepense } from "com/example/System_gestion_LEXUS/Services";

const DepensesPage = () => {
  const [list, setList] = useState([]);
  const [newD, setNewD] = useState({ montantDepense: "" });

  useEffect(() => { load(); }, []);

  const load = async () => {
    const res = await getDepenses();
    setList(res.data);
  };

  const handleAdd = async () => {
    await createDepense(newD);
    setNewD({ montantDepense: "" });
    load();
  };

  const handleDelete = async (id) => {
    await deleteDepense(id);
    load();
  };

  return (
    <div>
      <h2>Gestion des Dépenses</h2>
      <ul>
        {list.map(d => (
          <li key={d.id}>
            {d.montantDepense} MAD
            <button onClick={() => handleDelete(d.id)}>Supprimer</button>
          </li>
        ))}
      </ul>

      <h3>Ajouter une dépense</h3>
      <input type="number" placeholder="Montant" value={newD.montantDepense}
        onChange={e => setNewD({ ...newD, montantDepense: e.target.value })} />
      <button onClick={handleAdd}>Ajouter</button>
    </div>
  );
};

export default DepensesPage;
