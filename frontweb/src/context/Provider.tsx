import { ReactNode, useState } from 'react';
import AppContext from './AppContext';

interface CartProviderProps {
  children: ReactNode;
}

export function Provider({ children }: CartProviderProps): JSX.Element {
  
    const [cart, setCart] = useState([]);

    const value = {
        cart,
        setCart
    }
    
  return (
    <AppContext.Provider
      value={value}
    >
      {children}
    </AppContext.Provider>
  );
}

