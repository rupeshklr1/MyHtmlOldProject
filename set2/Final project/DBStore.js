const userDetails = [
    {empName:"rupesh",empPass:"123456"},
    {empName:"user",empPass:"123456"},
    {empName:"ind001",empPass:"123456"},
    {empName:"ad41926",empPass:"123456"},
    {empName:"343676",empPass:"123456"},
]
const loginItem ={
    keyItem:"login_acme_grocers",
    valueItem:"YES",
    userNameKey:"userNameKey"
}
const maxItemCart = 5;
const billSize = 6;
const itemDisplay ={
    tableFormat :{
        body:[{key:"productId",property:"class='eleField bonn'"},{key:"productName",property:"class='eleField  name-field'"},{key:"quCount"},{key:"unitCost"},{key:"txt"},{key:"txtCost",decimal:2},{key:"totalPrice",decimal:2}],
        header :[{titile:"Product id"},{titile:"Product Name",property:"class='eleField  name-field'"},{titile:"No.of Units"},{titile:"Unit price"},{titile:"Txn per%"},{titile:"Txn Total"},{titile:"Total Price"}]
    },
    billFormat :{
        body:[{key:"productName",property:"class='eleField bonn name-field'"},{key:"quCount"},{key:"unitCost"},{key:"txtCost",decimal:2},{key:"totalPrice",decimal:2}],
        header :[{titile:"Product Name",property:"class='eleField bonn name-field'"},{titile:"No.of Units"},{titile:"Unit price"},{titile:"Txn Total"},{titile:"Total Price"}]
    }
}

const pageName ={
    homepage : "index.htm",
    entrypage : "dataEntry.htm"
}
const billStyles =`
<style>
body{
    margin-top : 20px !important;
    border: solid 2px #000;
    padding: 15px;
    margin: auto;
    width: 400px;
}
.topSec{
    display: flex;
}

.eleField{
    padding-left: 10px;
    border-left: 2px solid;
    width: 100px !important;
    height: 40px !important;
}
.eleField.bonn{                
    border-left: 0px solid #fff;
}
.topSec.und{
    border-bottom: 2px #000 solid;
    border-bottom: 2px #000 solid;
    margin-bottom: 20px;
}
.topSec.und .eleField{
    padding: auto;
    padding-top: 20px;
    margin: auto; 
    border-left: 0px solid #fff;
}
.eleField.name-field {
    width: 250px !important;
    font-weight: bold;
    font-size: small;
    /* font-size: large;*/
}
</style>`;
function findValue(arr, key){
    try {
        var arr1 =[]
        arr.filter(function(ele){  
            arr1.push(ele[key]) 
        });
        return (arr1);        
    } catch (error) {
        console.log("error occured in function_findValue.The error is"+error.message || error);
    }
}
function numToWord(num){
    try {        
        var units = ["zero","one","two","three","four","five","six","seven","eight","nine"];
        function word99(num){
            try {        
                var two_digit=['Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen'];
                var tens =["","Ten","Tweenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","ninety"];
                var units = ["zero","one","two","three","four","five","six","seven","eight","nine"];
                var res = '';
                if(Math.floor(num/10)>1){
                    res +=tens[Math.floor(num/10)]
                }
                if (num>9 && num<20){
                    res +=" " +two_digit[Math.floor(num%10)]
                }else if(Math.floor(num%10)>0){
                    res +=" " +units[Math.floor(num%10)]
                }
                return res;
            } catch (error) {
                console.log("error occured in function_(numToWord [word99]).The error is"+error.message || error);
            }
        }
        if(num>99999 || num<=0){
            console.log(num,"given number not in range of 1-99,999.");
            return "given number b/n 1-99,999.";
        }
        var th = 'thousand',hr = 'hundred', res ='',val = 0;
        val = Math.floor(num/1000);
        if(val >0){
            res += word99(val)+ " "+th
        }
        if(Math.floor(num/100)%10){
            res += " "+units[Math.floor(num/100)%10]+ " "+hr
        }
        res += " "+word99(Math.floor(num%100))
        console.log(num+" >> "+res);
        return res;
    } catch (error) {
        console.log("error occured in function_(numToWord).The error is"+error.message || error);
    }
}

const productDetail =[
    {
      productId: 'p001',
      unitCost: 116,
      txt: 8,
      productName: 'milk pack',
      shippingPrice: 120
    },
    {
      productId: 'p002',
      unitCost: 157,
      txt: 17,
      productName: 'chips',
      shippingPrice: 80
    },
    {
      productId: 'p003',
      unitCost: 160,
      txt: 18,
      productName: 'biscuit pack',
      shippingPrice: 120
    },
    {
      productId: 'p004',
      unitCost: 346,
      txt: 24,
      productName: 'bread',
      shippingPrice: 80
    },
    {
      productId: 'p005',
      unitCost: 198,
      txt: 5,
      productName: 'rice',
      shippingPrice: 120
    },
    {
      productId: 'p006',
      unitCost: 381,
      txt: 24,
      productName: 'spaghetti',
      shippingPrice: 80
    },
    {
      productId: 'p007',
      unitCost: 105,
      txt: 16,
      productName: 'toothpaste',
      shippingPrice: 120
    },
    {
      productId: 'p008',
      unitCost: 220,
      txt: 7,
      productName: 'shampoo',
      shippingPrice: 80
    },
    {
      productId: 'p009',
      unitCost: 128,
      txt: 26,
      productName: 'soap',
      shippingPrice: 120
    },
    {
      productId: 'p010',
      unitCost: 344,
      txt: 16,
      productName: 'orange juice',
      shippingPrice: 80
    },
    {
      productId: 'p011',
      unitCost: 385,
      txt: 16,
      productName: 'toilet paper',
      shippingPrice: 120
    },
    {
      productId: 'p012',
      unitCost: 258,
      txt: 10,
      productName: 'cheese',
      shippingPrice: 80
    },
    {
      productId: 'p013',
      unitCost: 386,
      txt: 6,
      productName: 'butter',
      shippingPrice: 120
    },
    {
      productId: 'p014',
      unitCost: 373,
      txt: 18,
      productName: 'eggs',
      shippingPrice: 80
    },
    {
      productId: 'p015',
      unitCost: 265,
      txt: 12,
      productName: 'tomatoes',
      shippingPrice: 120
    },
    {
      productId: 'p016',
      unitCost: 311,
      txt: 25,
      productName: 'potatoes',
      shippingPrice: 80
    },
    {
      productId: 'p017',
      unitCost: 315,
      txt: 12,
      productName: 'onions',
      shippingPrice: 120
    },
    {
      productId: 'p018',
      unitCost: 398,
      txt: 21,
      productName: 'garlic',
      shippingPrice: 80
    },
    {
      productId: 'p019',
      unitCost: 245,
      txt: 23,
      productName: 'chocolate',
      shippingPrice: 120
    },
    {
      productId: 'p020',
      unitCost: 268,
      txt: 16,
      productName: 'cookies',
      shippingPrice: 80
    },
    {
      productId: 'p021',
      unitCost: 204,
      txt: 26,
      productName: 'soda',
      shippingPrice: 120
    },
    {
      productId: 'p022',
      unitCost: 133,
      txt: 25,
      productName: 'watermelon',
      shippingPrice: 80
    },
    {
      productId: 'p023',
      unitCost: 348,
      txt: 25,
      productName: 'lettuce',
      shippingPrice: 120
    },
    {
      productId: 'p024',
      unitCost: 170,
      txt: 18,
      productName: 'broccoli',
      shippingPrice: 80
    },
    {
      productId: 'p025',
      unitCost: 299,
      txt: 21,
      productName: 'carrots',
      shippingPrice: 120
    },
    {
      productId: 'p026',
      unitCost: 328,
      txt: 5,
      productName: 'apples',
      shippingPrice: 80
    },
    {
      productId: 'p027',
      unitCost: 196,
      txt: 19,
      productName: 'bananas',
      shippingPrice: 120
    },
    {
      productId: 'p028',
      unitCost: 117,
      txt: 16,
      productName: 'yogurt',
      shippingPrice: 80
    },
    {
      productId: 'p029',
      unitCost: 250,
      txt: 23,
      productName: 'cereal',
      shippingPrice: 120
    },
    {
      productId: 'p030',
      unitCost: 241,
      txt: 6,
      productName: 'coffee',
      shippingPrice: 80
    }
  ];
function createProductList() {
  let products = [];
  var itemset = [
      'handbag', 'milk pack', 'chips', 'biscuit pack', 'bread', 'rice', 'spaghetti', 'toothpaste', 'shampoo',
      'soap', 'orange juice', 'toilet paper', 'cheese', 'butter', 'eggs', 'tomatoes', 'potatoes', 'onions', 'garlic',
      'chocolate', 'cookies', 'soda', 'watermelon', 'lettuce', 'broccoli', 'carrots', 'apples', 'bananas', 'yogurt',
      'cereal', 'coffee', 'tea', 'chicken', 'beef', 'pasta sauce', 'ketchup', 'mustard', 'mayonnaise', 'pickles',
      'olive oil', 'vinegar', 'sugar', 'salt', 'pepper'
  ];
  // console.log(itemset.length)  
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
}