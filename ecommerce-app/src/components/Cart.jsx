import { useContext } from "react";
import { CartContext } from "../context/CartContext";

const Cart = () => {
  const { state } = useContext(CartContext);
  const { cart, removeFromCart } = state;


  // Calculate total price
  const totalPrice = cart.reduce((acc, item) => acc + item.price * item.quantity, 0);

  return (
    <div className="container mx-auto mt-10 p-5">
      <div className="bg-white p-6 rounded-lg shadow-lg">
        <h2 className="text-2xl font-bold mb-4">Cart</h2>
        {cart.length > 0 ? (
          <>
            {cart.map((item) => (
              <div key={item.id} className="flex justify-between items-center border-b py-4">
                <div>
                  <h3 className="text-lg font-semibold">{item.name}</h3>
                  <p>Price: ₹{item.price.toLocaleString()}</p>
                  <p>Quantity: {item.quantity}</p>
                </div>
                <button
                  onClick={() => removeFromCart(item.id)}
                  className="bg-blue-500 text-white px-4 py-2 rounded"
                >
                  Remove
                </button>
              </div>
            ))}
            <div className="text-center mt-6 text-2xl font-bold text-blue-700">
              Total = ₹{totalPrice.toLocaleString()}
            </div>
          </>
        ) : (
          <p className="text-lg">Your cart is empty.</p>
        )}
      </div>
    </div>
  );
};

export default Cart;
