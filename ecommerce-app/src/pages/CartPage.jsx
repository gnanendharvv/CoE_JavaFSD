import { useContext } from "react";
import { CartContext } from "../context/CartContext";

const CartPage = () => {
  const { state, dispatch } = useContext(CartContext);

  return (
    <div>
      <h1>Cart</h1>
      {state.cart.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        state.cart.map((item) => (
          <div key={item.id} className="cart-item">
            <h2>{item.name}</h2>
            <p>Price: ${item.price}</p>
            <p>Quantity: {item.quantity}</p>
            <button onClick={() => dispatch({ type: "REMOVE_FROM_CART", payload: item.id })}>
              Remove
            </button>
          </div>
        ))
      )}
    </div>
  );
};

export default CartPage;
