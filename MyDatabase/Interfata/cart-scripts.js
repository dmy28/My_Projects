src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"


function loadCart()
{
  cart = JSON.parse(localStorage.getItem("shoppingCart"));
}

loadCart();

displayCart();

function displayCart()
{
  var cartArray = listCart();
  var output = "";
  for(var i in cartArray)
  {
    output += "<p>"
    +cartArray[i].name
    +" "+cartArray[i].count
    +" x "+ cartArray[i].price
    +" = "+ cartArray[i].total
    +"</p>";
  }
}

function listCart() {
  var copyCart = [];
  for(var i in cart)
  {
    var item = cart[i];
    var itemCopy = {};
    for(var p in item)
    {
      itemCopy[p]=item[p];
    }
    itemCopy.total = (item.price * item.count).toFixed(2);
    copyCart.push(itemCopy);
  }
  return copyCart;
}
