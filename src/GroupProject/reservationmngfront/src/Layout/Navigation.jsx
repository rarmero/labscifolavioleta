import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./Layout";
import Home from "./Home";
import ReserveApp from "../Forms/Reserve/ReserveApp";
import PersonApp from "../Forms/Person/PersonApp";
import ChargingPointApp from "../Forms/ChargingPoint/ChargingPoint";

export default function Navigation() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Home />} />
            <Route path="reserve" element={<ReserveApp />} />
            <Route path="person" element={<PersonApp />} />
            <Route path="ChargingPoint" element={<ChargingPointApp />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}
