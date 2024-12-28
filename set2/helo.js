let products = [];
var itemset = [
    'handbag', 'milk pack', 'chips', 'biscuit pack', 'bread', 'rice', 'spaghetti', 'toothpaste', 'shampoo',
    'soap', 'orange juice', 'toilet paper', 'cheese', 'butter', 'eggs', 'tomatoes', 'potatoes', 'onions', 'garlic',
    'chocolate', 'cookies', 'soda', 'watermelon', 'lettuce', 'broccoli', 'carrots', 'apples', 'bananas', 'yogurt',
    'cereal', 'coffee', 'tea', 'chicken', 'beef', 'pasta sauce', 'ketchup', 'mustard', 'mayonnaise', 'pickles',
    'olive oil', 'vinegar', 'sugar', 'salt', 'pepper'
];
console.log(itemset.length)
 
for (let i = 1; i <= 30; i++) {
    let productId = "p" + (i < 10 ? "00" : "0") + i;
    let productName = itemset[i]; // Alternating product names
    let unitCost = Math.ceil(Math.random()*300)+102; // Alternating unit cost
    let txt = Math.ceil(Math.random()*26); // Tax (txt) varies based on the product
    let shippingPrice =  i % 2 === 0 ? 80 : 120; // Shipping price condition
 
    products.push({
        productId: productId,
        unitCost: unitCost,
        txt: txt,
        productName: productName,
        shippingPrice: shippingPrice
    });
}
 
console.log(products)