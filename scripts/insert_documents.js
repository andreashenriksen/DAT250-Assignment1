const { MongoClient } = require('mongodb');
const uri = 'mongodb://localhost:27017';

const client = new MongoClient(uri, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

async function run() {
    await client.connect();
    const db = client.db('MyDatabase'); 

    // Insert one document
    console.log("\nInserting one document:")
    result = await db.collection('inventory').insertOne({
      item: 'canvas',
      qty: 100,
      tags: ['cotton'],
      size: { h: 28, w: 35.5, uom: 'cm' },
    });

    console.log(result);

    // Find document
    console.log("\nFinding document:")
    cursor = db.collection('inventory').find({ item: 'canvas' });
    console.log(cursor.toArray())

    // Insert multiple documents
    console.log("\nInserting multiple documents:")
    result = await db.collection('inventory').insertMany([
      {
        item: 'journal',
        qty: 25,
        tags: ['blank', 'red'],
        size: { h: 14, w: 21, uom: 'cm' }
      },
      {
        item: 'mat',
        qty: 85,
        tags: ['gray'],
        size: { h: 27.9, w: 35.5, uom: 'cm' }
      },
      {
        item: 'mousepad',
        qty: 25,
        tags: ['gel', 'blue'],
        size: { h: 19, w: 22.85, uom: 'cm' }
      }
    ]);
    
    console.log(result)

    // Find documents
    console.log("\nFinding all documents:")
    cursor = db.collection('inventory').find({});
    console.log(cursor.toArray())

    await client.close();
}

run();
