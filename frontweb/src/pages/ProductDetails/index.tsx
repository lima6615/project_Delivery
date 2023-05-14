import './styles.css';
import { ReactComponent as ArrowIcon} from '../../assets/images/arrow.svg';
import ProductPrice from '../../components/ProductPrice';

const ProductDetails = () => {
    return(
        <div className="product-details-container">
            <div className="base-card product-details-card">
                <div className="goback-container">
                    <ArrowIcon />
                    <h2>VOLTAR</h2>
                </div>
                <div className="row">
                    <div className="col-xl-6">
                        <div className="img-container">
                            <img src="https://raw.githubusercontent.com/lima6615/project_Delivery/main/img/cachorro-quente.png" alt="Nome do Produto"/>
                        </div>
                        <div className="name-price-container">
                            <h1>Nome do Produto</h1>
                            <ProductPrice price={20.00}/>
                        </div>
                    </div>
                    <div className="col-xl-6">
                        <div className="description-container">
                            <h2>Descrição do produto</h2>
                            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Neque, qui.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProductDetails;