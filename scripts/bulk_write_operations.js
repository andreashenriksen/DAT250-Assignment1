const { MongoClient } = require('mongodb');
const uri = 'mongodb://localhost:27017';

const client = new MongoClient(uri, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

async function run() {

  await client.connect();
  const db = client.db('MyDatabase'); 

  const pizzas = db.collection('pizzas')

  console.log("\nInserting documents");
  result = pizzas.insertMany( [
    { _id: 0, type: "pepperoni", size: "small", price: 4 },
    { _id: 1, type: "cheese", size: "medium", price: 7 },
    { _id: 2, type: "vegan", size: "large", price: 8 }
  ])
  console.log(result);

  console.log("\nPerforming bulkwrite on pizzas collection");
  try {
    result = pizzas.bulkWrite( [
       { insertOne: { document: { _id: 3, type: "beef", size: "medium", price: 6 } } },
       { insertOne: { document: { _id: 4, type: "sausage", size: "large", price: 10 } } },
       { updateOne: {
          filter: { type: "cheese" },
          update: { $set: { price: 8 } }
       } },
       { deleteOne: { filter: { type: "pepperoni"} } },
       { replaceOne: {
          filter: { type: "vegan" },
          replacement: { type: "tofu", size: "small", price: 4 }
       } }
    ] )
    console.log(result);
  } catch( error ) {
    print( error )
  }

  await client.close()
}

run()
