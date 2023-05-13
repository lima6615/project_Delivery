import '../../App.css';
import './styles.css';

import { ReactComponent as MainImage } from '../../assets/images/home-delivery_adobe_express.svg';
import ButtonIcon from '../../components/ButtonIcon';
import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <>
      <div className="home-container">
        <div className="base-card home-card">
          <div className="home-content-container">
            <div>
              <h1>Venha saboriar essas gostosuras.</h1>
              <p>
                Ajudaremos você a encontrar os melhores produtos disponiveis
              </p>
            </div>
            <div>
              <Link to="/products">
                <ButtonIcon text="INICIE AGORA A SUA BUSCA"/>
              </Link>
            </div>
          </div>

          <div className="home-image-container">
            <MainImage />
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
