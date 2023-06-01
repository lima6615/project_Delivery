import './styles.css';

import Navbar from './Navbar';
import { Route, Switch } from 'react-router-dom';
import Products from './Products';

const Admin = () => {
  return (
    <div className="admin-container">
      <Navbar />
      <div className="admin-content">
        <Switch>
          <Route path="/admin/products">
              <Products />
          </Route>
          <Route path="/admin/categories">
              <h1> Category Crud</h1>
          </Route>
          <Route path="/admin/employee">
              <h1> Funcionarios Crud</h1>
          </Route>
        </Switch>
      </div>
    </div>
  );
};

export default Admin;
