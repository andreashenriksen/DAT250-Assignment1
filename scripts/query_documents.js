const { MongoClient } = require('mongodb');
const uri = 'mongodb://localhost:27017';

const client = new MongoClient(uri, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

async function run() {

    await client.connect();
    const db = client.db('MyDatabase'); 

    console.log("\nInserting documents");
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
          status: 'A'
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
    console.log(result);


    console.log("\nFinding all documents");
    cursor = db.collection('inventory').find({});
    console.log(cursor.toArray());


    console.log("\nFinding documents where status == D");
    cursor = db.collection('inventory').find({ status: 'D' });
    console.log(cursor.toArray());
       
    
    console.log("\nFinding documents where status == (A || D)");
    cursor = db.collection('inventory').find({
        status: { $in: ['A', 'D'] }
    });
    console.log(cursor.toArray());


    console.log("\nFinding all documents where status == D & qty < 30");
    cursor = db.collection('inventory').find({
        status: 'A',
        qty: { $lt: 30 }
    });
    console.log(cursor.toArray());


    console.log("\nFinding all documents where status == A || qty < 30");
    cursor = db.collection('inventory').find({
        $or: [{ status: 'A' }, { qty: { $lt: 30 } }]
    });
    console.log(cursor.toArray());


    console.log("\nFinding all documents where status == A & (qty < 30 || item.startsWith('p'))");
    cursor = db.collection('inventory').find({
        status: 'A',
        $or: [{ qty: { $lt: 30 } }, { item: { $regex: '^p' } }]
    });
    console.log(cursor.toArray());


    await client.close();
}

run()
