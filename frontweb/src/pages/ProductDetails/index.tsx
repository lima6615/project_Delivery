import { ReactComponent as ArrowIcon } from '../../assets/images/arrow.svg';
import ProductPrice from '../../components/ProductPrice';
import { Link, useParams } from 'react-router-dom';
import { Product } from '../../assets/types/product';
import axios from 'axios';
import { BASE_URL } from '../../util/request';
import { useContext, useEffect, useState } from 'react';
import ProductInfoLoader from './ProductInfoLoader';
import ProductDetailsLoader from './ProductDetailsLoader';

import './styles.css';
import AppContext from 'context/AppContext';

type UrlParams = {
  productId: string;
};

const ProductDetails = () => {
  const { productId } = useParams<UrlParams>();
  const [isLoading, setIsLoading] = useState(false);
  const [product, setProduct] = useState<Product>();

  const { cart, setCart } = useContext(AppContext);

  const addCart = () => {
    setCart([...cart, product]);
  };

  useEffect(() => {
    setIsLoading(true);
    axios
      .get(`${BASE_URL}/products/${productId}`)
      .then((response) => {
        setProduct(response.data);
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, [productId]);

  return (
    <div className="product-details-container">
      <div className="base-card product-details-card">
        <Link to="/products">
          <div className="goback-container">
            <ArrowIcon />
            <h2>VOLTAR</h2>
          </div>
        </Link>
        <div className="row">
          <div className="col-xl-6">
            {isLoading ? (
              <ProductInfoLoader />
            ) : (
              <>
                <div className="img-container">
                  <img src={product?.figure} alt={product?.name} />
                </div>
                <div className="name-price-container">
                  <h1>{product?.name}</h1>
                  {product && <ProductPrice price={product?.price} />}
                </div>
              </>
            )}
          </div>
          <div className="col-xl-6">
            {isLoading ? (
              <ProductDetailsLoader />
            ) : (
              <>
                <div className="description-container">
                  <h2>Descrição do Produto</h2>
                  <p>{product?.description}</p>
                </div>
              </>
            )}
          </div>
        </div>
        <div className="container-button">
          <button type="button" className="btn btn-primary" onClick={addCart}>
            Adicionar
          </button>
        </div>
      </div>
    </div>
  );
};

export default ProductDetails;
