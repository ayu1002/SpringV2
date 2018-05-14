import React from 'react';
import { Link } from 'react-router-dom';

export class HomeComponent extends React.Component {
    render() {
        return(
            <div>
                <h3> from home</h3>
                <Link to="/registerform"><button>Back to register</button></Link>
            </div>
        );
    }
}