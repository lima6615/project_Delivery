import CartItem from 'components/CartItem/CartItem';
import './style.css';
import { useContext } from 'react';
import AppContext from 'context/AppContext';
import { Category } from 'assets/types/category';

const Cart = () => {

    const {cart} = useContext(AppContext);

    return (
        <section className='cart'>
            <div className="cart-items">

                {
                    cart.map((cart: 
                        { id: any; name?: string; description?: string; figure?: string; price?: number; categories?: Category[]; }) => <CartItem  key={cart.id} product={{
                            id: 0,
                            name: '',
                            description: '',
                            figure: '',
                            price: 0,
                            categories: []
                        }}  />)
                }
            </div>
            <div className="cart-resumo">resumo do carrinho</div>
        </section>
    );
}

export default Cart;