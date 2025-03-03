import { useState, useContext } from "react";
import { CartContext } from "../context/CartContext";


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
    <div className="border rounded-lg p-4 shadow-md">

      <h2>{product.name}</h2>
      <p>₹{product.price}</p>
      <button className="bg-blue-500 text-white px-4 py-2 rounded" onClick={addToCart}>Add to Cart</button>


      {/* ✅ Show message when item is added */}
      {message && <p className="text-green-500">{message}</p>}

    </div>
  );
};

export default ProductCard;
