import React, { useEffect, useState } from "react";
import { getEncaissements, createEncaissement, deleteEncaissement } from "com/example/System_gestion_LEXUS/Services";

const EncaissementsPage = () => {
  const [list, setList] = useState([]);
  const [newE, setNewE] = useState({
    montantEncaisse: "",
    description: ""
  });

  useEffect(() => {
    load();
  }, []);

  const load = async () => {
    const res = await getEncaissements();
    setList(res.data);
  };

  const handleAdd = async () => {
    await createEncaissement(newE);
    setNewE({ montantEncaisse: "", description: "" });
    load();
  };

  const handleDelete = async (id) => {
    await deleteEncaissement(id);
    load();
  };

  return (
    <div>
      <h2>Gestion des Encaissements</h2>
      <ul>
        {list.map(e => (
          <li key={e.id}>
            {e.montantEncaisse} MAD - {e.description}
            <button onClick={() => handleDelete(e.id)}>Supprimer</button>
          </li>
        ))}
      </ul>

      <h3>Ajouter un encaissement</h3>
      <input type="number" placeholder="Montant" value={newE.montantEncaisse}
        onChange={e => setNewE({ ...newE, montantEncaisse: e.target.value })} />
      <input placeholder="Description" value={newE.description}
        onChange={e => setNewE({ ...newE, description: e.target.value })} />
      <button onClick={handleAdd}>Ajouter</button>
    </div>
  );
};

export default EncaissementsPage;
