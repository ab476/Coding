import type { Product } from "../dummy-products.js";
import { useShopingCart } from "../store/ShopingCartContext.js";

export interface ProductProps extends Product {}

export default function Product({
  id,
  image,
  title,
  price,
  description,
}: ProductProps) {
  const { onAddItemToCart } = useShopingCart();
  return (
    <article className="product">
      <img src={image} alt={title} />
      <div className="product-content">
        <div>
          <h3>{title}</h3>
          <p className="product-price">${price}</p>
          <p>{description}</p>
        </div>
        <p className="product-actions">
          <button
            onClick={() =>
              onAddItemToCart({
                id,
                name: title,
                price,
                quantity: 1,
              })
            }
          >
            Add to Cart
          </button>
        </p>
      </div>
    </article>
  );
}
