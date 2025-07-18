import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import ClientsPage from "./pages/Client";
import EncaissementsPage from "./pages/Encaissement";
import ReglementsPage from "./pages/Reglement";
import FacturesPage from "./pages/Facture";
import DepensesPage from "./pages/Depense";
import TypesPaiementPage from "./pages/TypesPaiement";
import ServicesPage from "./pages/Travail";

function App() {
  return (
    <Router>
      <nav>
        <Link to="/clients">Clients</Link> | 
        <Link to="/encaissements">Encaissements</Link> | 
        <Link to="/reglements">Reglements</Link> | 
        <Link to="/factures">Factures</Link> | 
        <Link to="/depenses">Depenses</Link> | 
        <Link to="/types-paiement">Types Paiement</Link> | 
        <Link to="/services">Services</Link>
      </nav>

      <Routes>
        <Route path="/clients" element={<ClientsPage />} />
        <Route path="/encaissements" element={<EncaissementsPage />} />
        <Route path="/reglements" element={<ReglementsPage />} />
        <Route path="/factures" element={<FacturesPage />} />
        <Route path="/depenses" element={<DepensesPage />} />
        <Route path="/types-paiement" element={<TypesPaiementPage />} />
        <Route path="/services" element={<ServicesPage />} />
      </Routes>
    </Router>
  );
}

export default App;
