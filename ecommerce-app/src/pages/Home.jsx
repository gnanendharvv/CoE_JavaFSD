import ProductCard from "../components/ProductCard";

const Home = () => {
  // Sample Products (Replace with API data if needed)
  const products = [
    { id: 1, name: "Laptop", price: 50000 },
    { id: 2, name: "Headphones", price: 2000 },
    { id: 3, name: "Smartphone", price: 30000 },
  ];

  return (
    <div className="container mx-auto p-5">
<h2 className="text-2xl font-bold mb-4 text-center">Available Products</h2>

      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
        {products.map((product) => (
          <ProductCard key={product.id} product={product} />
        ))}
      </div>
    </div>
  );
};

export default Home;
