import './styles.css';

import { Link } from 'react-router-dom';

import { Product } from '../../assets/types/product';
import ProductCard from '../../components/ProductCard';
import Pagination from '../../components/pagination';

const Catalog = () => {
  const product: Product = {
    id: 4,
    name: 'Cachorro-Quente',
    description: 'Pão , Salsicha, Queijo e Milho',
    figure:
      'https://raw.githubusercontent.com/lima6615/project_Delivery/main/img/cachorro-quente.png',

    price: 20.0,
    categories: [
      {
        id: 1,
        name: 'Hot-Dog',
      },
    ],
  };

  return (
    <div className="container my-4 catalog-container">
      <div className="row catalog-title-container">
        <h1>Catálago de Produtos</h1>
      </div>
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
      </div>

      <div className="row">
        <Pagination />
      </div>
    </div>
  );
};

export default Catalog;
