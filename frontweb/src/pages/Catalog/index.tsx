import { Product } from '../../assets/types/product';
import ProductCard from '../../components/ProductCard';

const Catalog = () => {
  const product: Product = {
    id: 4,
    name: 'Cachorro-Quente',
    description: 'Pão , Salsicha, Queijo e Milho',
    figure:"https://raw.githubusercontent.com/lima6615/project_Delivery/main/img/cachorro-quente.png",
    
    price: 20.0,
    categories: [
        {
            id: 1,
            name: 'Hot-Dog'
        }
    ]
  };

  return (
    <div className=" container my-4">
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ProductCard product={product} />
        </div>
      </div>
    </div>
  );
};

export default Catalog;
