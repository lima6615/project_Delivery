import './styles.css'

type Props = {
    price: number;
}

const ProductPrice = ({price} : Props) =>{
    return(
        <div className="product-price-container">
            <span>R$</span>
            <div>
                <h3>{price}</h3>
            </div>
        </div>
    );
}

export default ProductPrice;