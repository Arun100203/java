const cors = require('cors')
const express = require('express');
const mongoose = require('mongoose');

const app = express();


async function connectToDB(){
try {
    await mongoose.connect('mongodb://127.0.0.1:27017/temp', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    });
    console.log('MongoDB connected successfully');
} catch (error) {
    console.error('MongoDB connection failed:', error);
    process.exit(1); 
}
}
connectToDB();

const userSchema = new mongoose.Schema({
    name: String,
    email: String,
    phoneNumber: String,
});

const User = mongoose.model('User', userSchema);


app.use(cors())
app.use(express.json());


app.post('/submit', async (req, res) => {
    const formData = req.body;
    console.log('Received form data:', formData);
    //res.json({ message: 'Form data received successfully!' });
    try {
        const newUser = new User(formData);
        await newUser.save();
        console.log('data saved to database')
        res.json({ message: 'Form data saved successfully!' });
      } catch (error) {
        res.status(500).json({ error: 'Failed to save form data.' });
      }
  });

app.listen(8000, ()=>{
    console.log('connected')
})