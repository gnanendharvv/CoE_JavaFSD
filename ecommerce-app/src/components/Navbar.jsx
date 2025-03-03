import { Link } from "react-router-dom";
import { FaShoppingCart } from "react-icons/fa";
import "./Navbar.css"; // Import the CSS file

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="nav-container">
        {/* Logo / Brand Name */}
        <Link to="/" className="logo">E-Commerce</Link>

        {/* Navigation Links */}
        <div className="nav-links">
          <Link to="/" className="nav-item">Home</Link>
          <Link to="/cart" className="nav-item cart-link">
            Cart <FaShoppingCart className="cart-icon" />
          </Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
