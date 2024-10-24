import express from "express";
import cors from "cors";

const app = express();

import router from './routers/main.js';

app.use(express.json());
app.use(cors(
  {
    origin: "*",
    methods: ["GET", "POST"],
  }
));


app.get("/", (req, res) => {
  res.send("Hello World!");
});

app.use('/api/departamentos', router);

app.listen(4000, () => {
  console.log("Server is running on port 4000");
});

export default app;