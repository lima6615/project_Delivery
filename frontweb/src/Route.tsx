import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import Catalog from './pages/Catalog';
import Admin from './pages/Admin';
import Navbar from './components/Navbar';
import ProductDetails from './pages/ProductDetails';
import Auth from './pages/Admin/Auth';


const Routes = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Switch>
        <Route path="/" exact> 
            <Home />
        </Route>
        <Route path="/products" exact>
            <Catalog />    
        </Route>
        <Route path="/products/:productId">
            <ProductDetails />    
        </Route>
        <Redirect from="/admin/auth" to="/admin/auth/login" exact/>
        <Route path="/admin/auth">
          <Auth />
        </Route>
        <Redirect from="/admin" to="/admin/products" exact/>
        <Route path="/admin">
            <Admin />    
        </Route>
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;
