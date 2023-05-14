import './styles.css';
import '../../App.css';

import ProductPrice from '../ProductPrice';
import { Product } from '../../assets/types/product';

type Props = {
  product: Product;
};

const ProductCard = ({product} :  Props) => {
  return (
    <div className="base-card product-card">
      <div className="card-top-container">
        <img src={product.figure} alt={product.name} />
      </div>
      <div className="card-botton-container">
        <h6>{product.name}</h6>
        <ProductPrice price = {product.price}/>
      </div>
    </div>
  );
};

export default ProductCard;
