import { useState, useContext } from "react";
import { CartContext } from "../context/CartContext";
import "./ProductCard.css"; // Import the CSS file

const ProductCard = ({ product }) => {
  const { dispatch } = useContext(CartContext);
  const [message, setMessage] = useState(""); // ✅ State to show "Item added" message

  const addToCart = () => {
    dispatch({ type: "ADD_TO_CART", payload: product });

    // ✅ Show message when item is added
    setMessage(`${product.name} added to cart!`);

    // ✅ Hide message after 2 seconds
    setTimeout(() => setMessage(""), 2000);
  };

  return (
    <div className="product-card">
      <h2>{product.name}</h2>
      <p>₹{product.price}</p>
      <button className="add-to-cart-btn" onClick={addToCart}>Add to Cart</button>

      {/* ✅ Show message when item is added */}
      {message && <p className="added-message">{message}</p>}
    </div>
  );
};

export default ProductCard;
