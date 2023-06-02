import { Outlet, Link } from "react-router-dom";
import React from "react";

export default function Layout() {
  return (
    <>
      <nav>
        <Link to="/">Home</Link>
        <span> </span>
        <Link to="/reserve">Reserves</Link>
        <span> </span>
        <Link to="/person">Persons</Link>
        <span> </span>
        <Link to="/ChargingPoint">ChargingPoint</Link>
        <span> </span>
      </nav>

      <Outlet />
    </>
  );
}
