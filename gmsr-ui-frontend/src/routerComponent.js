import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import App from './App';
import  RegisterFormComponent  from './registerFormComponent';
import { HomeComponent } from './homeComponent';
import { RegisterComponent } from './registerComponent';

export const RouterComponent = () => {
    return(
        <Router>
            <div>
                <Route exact path="/" component={ App }/>
                <Route path="/registerform" component={ RegisterFormComponent } />
                <Route path="/home" component={ HomeComponent }/>
                <Route path="/register" component={ RegisterComponent }/>
            </div> 
        </Router>
    );
}