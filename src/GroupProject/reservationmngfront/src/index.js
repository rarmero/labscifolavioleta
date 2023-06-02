import React from "react";
import ReactDOM from "react-dom";
import Navigation from "./Layout/Navigation";
import { Container } from "semantic-ui-react";

const App = ({ children }) => (
  <Container
    fluid
    style={{
      width: "80%",
      margin: "0 auto",
      padding: "24px",
      backgroundColor: "#F0F0F0"
    }}
  >
    {children}
  </Container>
);

const rootElement = document.getElementById("root");
ReactDOM.render(
  <App>
    <Navigation />
  </App>,
  rootElement
);