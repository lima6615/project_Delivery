import axios, { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

import { Product } from '../../assets/types/product';
import { SpringPage } from '../../assets/types/spring';
import Pagination from '../../components/pagination';
import ProductCard from '../../components/ProductCard';
import { BASE_URL } from '../../util/request';

import './styles.css';
import CartButton from '../../components/CartButton';

const Catalog = () => {

  const [page, setPage] = useState<SpringPage<Product>>();

  useEffect(() => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: "/products",
      baseURL: BASE_URL,
      params: {
        page: 0,
        size: 12,
      },
    };
    axios(params).then((response) => {
      setPage(response.data);
    });
  }, []);

  return (
    <div className="container my-4 catalog-container">
      <div className="row catalog-title-container">
        <h1>Catálago de Produtos</h1>
        <CartButton />
      </div>
      <div className="row">
        {page?.content.map((product) => (
          <div className="col-sm-6 col-lg-4 col-xl-3" key={product.id}>
            <Link to={`/products/${product.id}`}>
              <ProductCard product={product} />
            </Link>
          </div>
        ))}
      </div>
      
      <div className="row">
        <Pagination />
      </div>
    </div>
  );
};

export default Catalog;
