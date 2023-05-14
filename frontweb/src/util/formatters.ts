export const formatter = (price: number) =>{
    const params ={maximunFractionDigits: 2, minimumFractionDigits: 2};
    return new Intl.NumberFormat('pt-BR',params).format(price);
}