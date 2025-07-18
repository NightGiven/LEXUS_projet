import React, { useEffect, useState } from "react";
import { getServices, createService, deleteService } from "com/example/System_gestion_LEXUS/Services";

const ServicesPage = () => {
  const [list, setList] = useState([]);
  const [newS, setNewS] = useState({ frais: "" });

  useEffect(() => { load(); }, []);

  const load = async () => {
    const res = await getServices();
    setList(res.data);
  };

  const handleAdd = async () => {
    await createService(newS);
    setNewS({ frais: "" });
    load();
  };

  const handleDelete = async (id) => {
    await deleteService(id);
    load();
  };

  return (
    <div>
      <h2>Gestion des Services</h2>
      <ul>
        {list.map(s => (
          <li key={s.id}>
            Service #{s.id} - {s.frais} MAD
            <button onClick={() => handleDelete(s.id)}>Supprimer</button>
          </li>
        ))}
      </ul>

      <h3>Ajouter un service</h3>
      <input type="number" placeholder="Frais" value={newS.frais}
        onChange={e => setNewS({ ...newS, frais: e.target.value })} />
      <button onClick={handleAdd}>Ajouter</button>
    </div>
  );
};

export default ServicesPage;
