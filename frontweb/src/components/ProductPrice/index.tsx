import { formatter } from '../../util/formatters';
import './styles.css'

type Props = {
    price: number;
}

const ProductPrice = ({price} : Props) =>{
    return(
        <div className="product-price-container">
            <span>R$</span>
            <div>
                <h3>{formatter(price)}</h3>
            </div>
        </div>
    );
}

export default ProductPrice;