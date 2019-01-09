import React from "react";
import ReactDom from "react-dom";
import "bootstrap/dist/css/bootstrap.css";
import Counter from "./components/counterComponent";

ReactDom.render(<Counter />, document.getElementById("counterContainer"));
