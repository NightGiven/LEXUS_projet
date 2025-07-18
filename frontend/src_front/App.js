import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import ClientsPage from "./pages/Client";
import EncaissementsPage from "./pages/Encaissement";
import ReglementsPage from "./pages/Reglement";
import FacturesPage from "./pages/Facture";
import DepensesPage from "./pages/Depense";
import ServicesPage from "./pages/Travail";
import TypesPaiementPage from "./pages/TypesPaiement";

function App() {
  return (
    <Router>
      <div style={{ padding: "20px", fontFamily: "Arial" }}>
        <h1 style={{ color: "#007bff" }}>Gestion des règlements et encaissements</h1>

        {/* Menu de navigation */}
        <nav style={{ marginBottom: "20px" }}>
          <Link to="/" style={{ margin: "0 10px" }}>Clients</Link>
          <Link to="/encaissements" style={{ margin: "0 10px" }}>Encaissements</Link>
          <Link to="/reglements" style={{ margin: "0 10px" }}>Règlements</Link>
          <Link to="/factures" style={{ margin: "0 10px" }}>Factures</Link>
          <Link to="/depenses" style={{ margin: "0 10px" }}>Dépenses</Link>
          <Link to="/services" style={{ margin: "0 10px" }}>Services</Link>
          <Link to="/types-paiement" style={{ margin: "0 10px" }}>Types de Paiement</Link>
        </nav>

        {/* Gestion des routes */}
        <Routes>
          <Route path="/" element={<ClientsPage />} />
          <Route path="/encaissements" element={<Encaissement />} />
          <Route path="/reglements" element={<Reglement />} />
          <Route path="/factures" element={<Facture/>} />
          <Route path="/depenses" element={<Depense />} />
          <Route path="/services" element={<Travail />} />
          <Route path="/types-paiement" element={<TypesPaiement />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
