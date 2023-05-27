import { Route, Switch } from 'react-router-dom';
import {ReactComponent as AuthImage} from '../../../assets/images/login.svg';
import Login from './Login';

import './styles.css';


const Auth = () => {
    return(
        <div className="auth-container">
            <div className="auth-banner-container">
                <h1>Divulgue seus produtos no Delivery</h1>
                <p>Faça parte do nosso catálogo de divulgação</p>
                <AuthImage />
            </div>
            <div className="auth-form-container">
                <Switch>
                    <Route path="/admin/auth/login">
                        <Login />
                    </Route>
                </Switch>
                <Switch>
                    <Route path="/admin/auth/signup">
                        <h1>Card de Signup</h1>
                    </Route>
                </Switch>
                <Switch>
                    <Route path="/admin/auth/recover">
                        <h1>Card de Recover</h1>
                    </Route>
                </Switch>
            </div>
        </div>
    )
}

export default Auth;