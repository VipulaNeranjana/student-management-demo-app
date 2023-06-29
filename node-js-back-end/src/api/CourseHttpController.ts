import express from 'express';
import {datasource} from "../db/dbcp";

export const router = express.Router();

router.get('/', async (req, res) => {
    const result = await datasource.query('SELECT * FROM course');
    res.json(result);
});