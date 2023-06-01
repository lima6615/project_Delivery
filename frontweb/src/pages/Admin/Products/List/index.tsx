import { Link } from "react-router-dom";
import ProductCrudCard from "../ProductCrudCard";
import { useEffect, useState } from "react";
import { SpringPage } from "../../../../assets/types/spring";
import { Product } from "../../../../assets/types/product";

import './styles.css';
import axios, { AxiosRequestConfig } from "axios";
import { BASE_URL } from "../../../../util/request";

const List = () =>{

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

    return(
        <div className="product-card-container">
            <div className="product-crud-bar-container">
                <Link to="/admin/products/create" className="product-link">
                    <button className="btn btn-primary text-white btn-crud-add">ADICIONAR</button>
                </Link>
                <div className = "base-card product-filter-container"> Buscar </div>
            </div>
            <div className="row">

                {
                  page?.content.map(product => (
                    <div key={product.id}>
                        <ProductCrudCard product={product}/>
                    </div>
                  ))
                }
            </div>
        </div>
    );
}

export default List;