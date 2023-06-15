import { Category } from "./category";

export type Product = {
  id: number;
  name: string;
  description: string;
  figure: string
  price: number;
  categories: Category[];
};

export interface Stock {
  id: number;
  amount: number;
}