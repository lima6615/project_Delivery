import { useState } from 'react';
import Routes from './Route';
import './assets/styles/custom.scss';
import 'react-toastify/dist/ReactToastify.css'
import { ToastContainer } from 'react-toastify';
import { AuthContext, AuthContextData } from 'AuthContext';
import { Provider } from 'context/Provider';
import Cart from 'components/Cart';

function App() {

  const [authContextData, setAuthContextData] = useState<AuthContextData>({
    authenticated: false,
  });

  return (
    <>
      <AuthContext.Provider value={{ authContextData, setAuthContextData}}>
          <Routes />
          <ToastContainer />     
      </AuthContext.Provider>
      <Provider>
        <Cart />
      </Provider>
    </>
  );
}

export default App;
