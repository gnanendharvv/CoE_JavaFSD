import { useContext } from "react";
import { CartContext } from "../context/CartContext";

const CartPage = () => {
  const { state, dispatch } = useContext(CartContext);

  return (
    <div className="container mx-auto p-5">
      <h1 className="text-2xl font-bold">Cart</h1>

      {state.cart.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        state.cart.map((item) => (
          <div key={item.id} className="cart-item border-b py-4">
            <h2 className="text-lg font-semibold">{item.name}</h2>
            <p>Price: ₹{item.price}</p>
            <p>Quantity: {item.quantity}</p>
            <button onClick={() => dispatch({ type: "REMOVE_FROM_CART", payload: item.id })} className="bg-red-500 text-white px-4 py-2 rounded">
              Remove
            </button>

          </div>
        ))
      )}
    </div>
  );
};

export default CartPage;
