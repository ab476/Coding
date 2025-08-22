import { useState } from "react";

import Header from "./components/Header.jsx";
import Shop from "./components/Shop.jsx";
import { DUMMY_PRODUCTS } from "./dummy-products.js";
import { ShopingCartProvider } from "./store/ShopingCartContext.js";

export interface ShoppingCartItem {
  id: string;
  name: string;
  price: number;
  quantity: number;
}
export interface ShoppingCart {
  items: ShoppingCartItem[];
}
function App() {

  return (
    <ShopingCartProvider>
      <Header
        
      />
      <Shop  />
    </ShopingCartProvider>
  );
}

export default App;

