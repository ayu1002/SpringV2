import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import {RegisterComponent} from './registerComponent';
import {RegisterFormComponent} from './registerFormComponent';

class App extends Component {
  render() {
    return (
      <RegisterComponent/>
    );
  }
}

export default App;
