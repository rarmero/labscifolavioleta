import { Outlet, Link } from "react-router-dom";
import React from "react";
import Footer from "./Footer";

export default function Layout() {
  return (
    <>
      <nav>
        <Link to="/">Home</Link>
        <span>|</span>
        <Link to="/BookList">BookList</Link>
        <span>|</span>
        <Link to="/BookList2">BookList2</Link>
        <span>|</span>
        <Link to="/RestApiEx1">RestApiEx1</Link>
        <span>|</span>
        <Link to="/RestApiEx2">RestApiEx2</Link>
        <span>|</span>
        <Link to="/RestApiEx3Index">RestApiEx3Index</Link>
        <span>|</span>
        <Link to="/RestApiEx4">RestApiEx4</Link>
        <span>|</span>
        <Link to="/ListOil">ListOil</Link>
        <span>|</span>
      </nav>
      <Outlet />
      <Footer />
    </>
  );
}