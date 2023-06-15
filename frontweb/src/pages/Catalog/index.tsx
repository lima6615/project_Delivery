import { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

import { Product } from '../../assets/types/product';
import { SpringPage } from '../../assets/types/vendor/spring';
import Pagination from '../../components/pagination';
import ProductCard from '../../components/ProductCard';

import CartButton from '../../components/CartButton';
import { requestBackend } from '../../util/request';
import CardLoader from './CardLoader';

import './styles.css';

const Catalog = () => {

  const [page, setPage] = useState<SpringPage<Product>>();
  const [isLoading, setIsLoading] = useState(false);

  const getProducts = (pageNumber: number) => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: '/products',
      params: {
        page: pageNumber,
        size: 12,
      },
    };

    setIsLoading(true);
    requestBackend(params)
      .then((response) => {
        setPage(response.data);
      })
      .finally(() => {
        setIsLoading(false);
      });
  }

  useEffect(() => {
    getProducts(0);
  }, []);

  return (
    <div className="container my-4 catalog-container">
      <div className="row catalog-title-container">
        <h1>Catálago de Produtos</h1>
        <CartButton />
      </div>
      <div className="row">
        {isLoading ? (
          <CardLoader />
        ) : (
          page?.content.map((product) => (
            <div className="col-sm-6 col-lg-4 col-xl-3" key={product.id}>
              <Link to={`/products/${product.id}`}>
                <ProductCard product={product} />
              </Link>
            </div>
          ))
        )}
      </div>
      
      <div className="row">
        <Pagination 
           pageCount={page ? page.totalPages : 0} 
           range={3} 
           onChange={getProducts}
        />
      </div>
    </div>
  );
};

export default Catalog;
