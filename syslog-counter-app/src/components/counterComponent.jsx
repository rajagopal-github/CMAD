import React, { Component } from "react";

export class Counter extends Component {
  constructor() {
    super();
    this.state = {
      errorCounter: 0,
      warningCounter: 0,
      infoCounter: 0
    };
  }
  updateCounterStore() {
    fetch("http://localhost:8080/v1/network/health/v1/events/syslog/counters")
      .then(results => {
        return results.json();
      })
      .then(data => {
        this.setState({ errorCounter: data[0].count });
        this.setState({ warningCounter: data[1].count });
        this.setState({ infoCounter: data[2].count });
      });
  }
  componentWillMount() {
    this.updateCounterStore();
  }

  componentDidMount() {
    this.interval = setInterval(counterInterval => {
      this.updateCounterStore();
    }, 3000);
  }

  componentWillUnmount() {
    clearInterval(this.interval);
  }

  render() {
    return (
      <div className="row counterContainer" id="counterContainer">
        <div className="col-lg-4 text-center" id="errorDiv">
          <div className="counterLabel">
            <label id="errorLabel">Error</label>
          </div>
          <div className="counterBoxError" id="counterBoxError">
            <label>{this.state.errorCounter}</label>
          </div>
        </div>
        <div className="col-lg-4 text-center">
          <div className="counterLabel">
            <label>Warning</label>
          </div>
          <div className="counterBoxWarning" id="counterBoxWarning">
            <label>{this.state.warningCounter}</label>
          </div>
        </div>
        <div className="col-lg-4 text-center">
          <div className="counterLabel">
            <label>Info</label>
          </div>
          <div className="counterBoxInfo" id="counterBoxInfo">
            <label>{this.state.infoCounter}</label>
          </div>
        </div>
      </div>
    );
  }
}
export default Counter;
