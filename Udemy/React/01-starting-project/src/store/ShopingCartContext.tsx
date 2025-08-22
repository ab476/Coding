import React from "react";
import type { ShoppingCart, ShoppingCartItem } from "../App.js";

interface ShopingCartContext extends ShoppingCart {
  onUpdateCartItemQuantity: (id: string, quantity: number) => void;
  onAddItemToCart: (item: ShoppingCartItem) => void;
  onRemoveItemFromCart: (id: string) => void;
}
const ShopingCartContext = React.createContext<ShopingCartContext>({
    items: [],
    onUpdateCartItemQuantity: () => { },
    onAddItemToCart: () => { },
    onRemoveItemFromCart: () => { },

});
// Separate action types
type AddItemAction = {
  type: "ADD_ITEM";
  payload: ShoppingCartItem;
};

type RemoveItemAction = {
  type: "REMOVE_ITEM";
  payload: { id: string };
};

type UpdateItemQuantityAction = {
  type: "UPDATE_ITEM_QUANTITY";
  payload: { id: string; quantity: number };
};

// Union of all actions
type ShoppingCartAction =
  | AddItemAction
  | RemoveItemAction
  | UpdateItemQuantityAction;
function shopingCartReducer (prevCart: ShoppingCart, action: ShoppingCartAction) {
    switch (action.type) {
      case "ADD_ITEM":
        return {
          ...prevCart,
          items: [...prevCart.items, action.payload],
        };
      case "REMOVE_ITEM":
        return {
          ...prevCart,
          items: prevCart.items.filter((item) => item.id !== action.payload.id),
        };
      case "UPDATE_ITEM_QUANTITY":
        return {
          ...prevCart,
          items: prevCart.items.map((item) =>
            item.id === action.payload.id && (item.quantity + action.payload.quantity) >= 0
              ? { ...item, quantity: item.quantity + action.payload.quantity }
              : item
          ),
        };
      default:
        return prevCart;
    }
  }
export const ShopingCartProvider: React.FC<{ children: React.ReactNode }> = ({
  children,
}) => {
  const [cart, dispatch] = React.useReducer(shopingCartReducer, {
    items: [],
  });

  const onUpdateCartItemQuantity = (id: string, quantity: number) => {
    dispatch({
      type: "UPDATE_ITEM_QUANTITY",
      payload: { id, quantity },
    });
  };

  const onAddItemToCart = (item: ShoppingCartItem) => {
    dispatch({
      type: "ADD_ITEM",
      payload: item,
    });
  };

  const onRemoveItemFromCart = (id: string) => {
    dispatch({
      type: "REMOVE_ITEM",
      payload: { id },
    });
  };

  return (
    <ShopingCartContext.Provider
      value={{
        items: cart.items,
        onUpdateCartItemQuantity,
        onAddItemToCart,
        onRemoveItemFromCart,
      }}
    >
      {children}
    </ShopingCartContext.Provider>
  );
};

export const useShopingCart = () => {
    const context = React.useContext(ShopingCartContext);
    if (!context) {
        throw new Error("useShopingCart must be used within a ShopingCartProvider");
    }
    return context;
}