import { Link } from "react-router-dom";
import { FaShoppingCart } from "react-icons/fa";


const Navbar = () => {
  return (
    <nav className="bg-gray-800 p-4">
      <div className="container mx-auto flex justify-between items-center">

        {/* Logo / Brand Name */}
        <Link to="/" className="text-white text-lg font-bold">E-Commerce</Link>


        {/* Navigation Links */}
        <div className="flex space-x-4">
          <Link to="/" className="text-white">Home</Link>
          <Link to="/cart" className="text-white flex items-center">
            Cart <FaShoppingCart className="ml-1" />
          </Link>
        </div>

      </div>
    </nav>
  );
};

export default Navbar;
