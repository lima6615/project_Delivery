import './styles.css'

const Form = () =>{

    /*const { register, hadlerSubmit, formState: {errors} } = useForm<Product>()

    const onSubmit = (formData: Product) => {
    }*/

    return(
        <div>
            <div className="base-card product-crud-form-card">
                <h1 className="product-crud-form-title">DADOS DO PRODUTO</h1>
            
                <form >
                    <div className="row product-crud-inputs-left-container">
                        <div className="col-lg-6 product-crud-form-inputs-left">
                            <div className="margim-botton-30">
                                <input type="text" className="form-control base-input" />
                            </div>
                            <div className="margim-botton-30">
                                <input type="text" className="form-control base-input" />
                            </div>
                            <div> 
                                <input type="text" className="form-control base-input" />
                            </div>
                        </div>
                        <div className="col-lg-6">
                            <div>
                                <textarea name="" rows={5} className="form-control base-input h-auto" />
                            </div>
                            
                        </div>
                    </div>

                    <div className="product-crud-buttons-container">
                        <button className="btn btn-outline-danger product-crud-button">CANCELAR</button>
                        <button className="btn btn-primary product-crud-button text-white">SALVAR</button>
                    </div>
                </form>
            
            </div>
        </div>
    );
}

export default Form;