import React, { Component } from "react";
class ShoppingCounter extends Component {
  constructor() {
    this.state = {
      count: 0
    };
  }
  render() {
    return (
      <div>
        <span className="badge">{this.state.count}</span>
        <button className="button">Increment</button>
      </div>
    );
  }
}
export default ShoppingCounter;
