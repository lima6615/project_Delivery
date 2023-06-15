import ProductPrice from 'components/ProductPrice';
import { BsCartDashFill } from 'react-icons/bs';
import { Product } from 'assets/types/product';

import './styles.css'

type Props = {
    product: Product;
};

const CartItem = ({product} : Props) => {

    return(
        <section className="cart-item">
            <img src={product.figure} 
                alt="imagem do produto" 
                className="cart-item-image" 
            />

            <div className="cart-item-content">
                <h3 className="cart-item-title">{product.name}</h3>
                <h3 className="cart-item-price"> <ProductPrice price={8} /> </h3>

                <button
                    type="button"
                    className="button-remove-item"
                >
                    <BsCartDashFill />
                </button>
            </div>
        </section>
    );
}


export default CartItem;