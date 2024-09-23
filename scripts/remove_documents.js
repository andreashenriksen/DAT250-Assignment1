const { MongoClient } = require('mongodb');
const uri = 'mongodb://localhost:27017';

const client = new MongoClient(uri);

async function run() {

  await client.connect();
  const db = client.db('MyDatabase'); 


  console.log("\nInserting documents")
  result = await db.collection('inventory').insertMany([
    {
      item: 'journal',
      qty: 25,
      size: { h: 14, w: 21, uom: 'cm' },
      status: 'A'
    },
    {
      item: 'notebook',
      qty: 50,
      size: { h: 8.5, w: 11, uom: 'in' },
      status: 'P'
    },
    {
      item: 'paper',
      qty: 100,
      size: { h: 8.5, w: 11, uom: 'in' },
      status: 'D'
    },
    {
      item: 'planner',
      qty: 75,
      size: { h: 22.85, w: 30, uom: 'cm' },
      status: 'D'
    },
    {
      item: 'postcard',
      qty: 45,
      size: { h: 10, w: 15.25, uom: 'cm' },
      status: 'A'
    }
  ]); 
  console.log(result)

  console.log("\nDeleting all documents")
  result = await db.collection('inventory').deleteMany({});
  console.log(result);

  console.log("\nInserting documents again after deleting all")
  result = await db.collection('inventory').insertMany([
    {
      item: 'journal',
      qty: 25,
      size: { h: 14, w: 21, uom: 'cm' },
      status: 'A'
    },
    {
      item: 'notebook',
      qty: 50,
      size: { h: 8.5, w: 11, uom: 'in' },
      status: 'P'
    },
    {
      item: 'paper',
      qty: 100,
      size: { h: 8.5, w: 11, uom: 'in' },
      status: 'D'
    },
    {
      item: 'planner',
      qty: 75,
      size: { h: 22.85, w: 30, uom: 'cm' },
      status: 'D'
    },
    {
      item: 'postcard',
      qty: 45,
      size: { h: 10, w: 15.25, uom: 'cm' },
      status: 'A'
    }
  ]); 
  console.log(result)
  
  console.log("\nDeleting all documents that match the condition status == A");
  result = await db.collection('inventory').deleteMany({ status: 'A' });
  console.log(result);

  console.log("\nDeleting one document that matches condition status == D");
  result = await db.collection('inventory').deleteOne({ status: 'D' });
  console.log(result);
  
  await client.close()
}

run()
