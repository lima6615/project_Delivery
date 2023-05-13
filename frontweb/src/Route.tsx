import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import Catalog from './pages/Catalog';
import Admin from './pages/Admin';
import Navbar from './components/Navbar';


const Routes = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Switch>
        <Route path="/" exact> 
            <Home />
        </Route>
        <Route path="/products">
            <Catalog />    
        </Route>
        <Route path="/admin">
            <Admin />    
        </Route>
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;