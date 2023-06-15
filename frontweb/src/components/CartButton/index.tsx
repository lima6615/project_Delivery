import { AiOutlineShoppingCart } from 'react-icons/ai';

import './styles.css';

const CartButton = () => {
    return (
        <button type ="button" className="cart-button">
            <AiOutlineShoppingCart />
            <span className="cart-status">1</span>
        </button>
    );
}

export default CartButton;