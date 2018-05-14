import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {App} from './App';
import registerServiceWorker from './registerServiceWorker';
import {RouterComponent} from './routerComponent';

ReactDOM.render(<RouterComponent />, document.getElementById('root'));
registerServiceWorker();
